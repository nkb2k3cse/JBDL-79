package com.example.service;

import com.example.TxnCompletedPayload;
import com.example.TxnInitPayload;
import com.example.WalletUpdatedPayload;
import com.example.dto.PGPaymentStatusDTO;
import com.example.entity.Wallet;
import com.example.repo.WalletRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class WalletService {

    private static Logger LOGGER = LoggerFactory.getLogger(WalletService.class);


    @Autowired
    private WalletRepo walletRepo;

    @Value("${txn.completed.topic}")
    private String txnCompletedTopic;

    @Value("${wallet.updated.topic}")
    private String walletUpdatedTopic;


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @Transactional
    public void walletTxn(TxnInitPayload txnInitPayload) throws ExecutionException, InterruptedException {
        Wallet fromWallet = walletRepo.findByUserId(txnInitPayload.getFromUserId());
        TxnCompletedPayload txnCompletedPayload = new TxnCompletedPayload();
        txnCompletedPayload.setId(txnInitPayload.getId());
        txnCompletedPayload.setRequestId(txnInitPayload.getRequestId());
        if(fromWallet.getBalance() < txnInitPayload.getAmount()){
            txnCompletedPayload.setSuccess(false);
            txnCompletedPayload.setReason("Low Balance");
        }
        else{
            Wallet toWallet = walletRepo.findByUserId(txnInitPayload.getToUserId());
            fromWallet.setBalance(fromWallet.getBalance() - txnInitPayload.getAmount());
            toWallet.setBalance(toWallet.getBalance() + txnInitPayload.getAmount());
            txnCompletedPayload.setSuccess(true);

            WalletUpdatedPayload walletUpdatedPayload1 = new WalletUpdatedPayload(
                    fromWallet.getUserEmail(),
                    fromWallet.getBalance(),
                    txnInitPayload.getRequestId()
            );

            WalletUpdatedPayload walletUpdatedPayload2 = new WalletUpdatedPayload(
                    toWallet.getUserEmail(),
                    toWallet.getBalance(),
                    txnInitPayload.getRequestId()
            );

            Future<SendResult<String,Object>> walletUpdatedFuture1  = kafkaTemplate.send(walletUpdatedTopic,walletUpdatedPayload1.getUserEmail(),walletUpdatedPayload1);
            LOGGER.info("Pushed WalletUpdated to kafka: {}",walletUpdatedFuture1.get());

            Future<SendResult<String,Object>> walletUpdatedFuture2  = kafkaTemplate.send(walletUpdatedTopic,walletUpdatedPayload2.getUserEmail(),walletUpdatedPayload2);
            LOGGER.info("Pushed WalletUpdated to kafka: {}",walletUpdatedFuture2.get());
        }
        Future<SendResult<String,Object>> future  = kafkaTemplate.send(txnCompletedTopic,txnInitPayload.getFromUserId().toString(),txnCompletedPayload);
        LOGGER.info("Pushed TxnCompleted to kafka: {}",future.get());
    }

    public String processPgTxnId(String pgTxnId){
        PGPaymentStatusDTO pgPaymentStatusDTO = restTemplate.getForObject("http://localhost:9090/pg-service/payment-status/"+pgTxnId, PGPaymentStatusDTO.class);
            if (pgPaymentStatusDTO.getStatus().equalsIgnoreCase("SUCCESS")) {
                Wallet wallet = walletRepo.findByUserId(pgPaymentStatusDTO.getUserId());
                wallet.setBalance(wallet.getBalance() + pgPaymentStatusDTO.getAmount());
                walletRepo.save(wallet);
                return "Wallet Updated";
            }
            else{
                return "PG Txn Failed";
            }
    }
}
