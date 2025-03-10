package com.example.config;

import com.example.TxnCompletedPayload;
import com.example.entity.Transaction;
import com.example.entity.TxnStatusEnum;
import com.example.repo.TransactionRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class TransactionKafkaConsumerConfig {

    private static Logger LOGGER = LoggerFactory.getLogger(TransactionKafkaConsumerConfig.class);

    private static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private TransactionRepo txnRepo;

    @KafkaListener(topics = "${txn.completed.topic}", groupId = "txn")
    public void consumeTxnCompleted(ConsumerRecord payload) throws JsonProcessingException {
        TxnCompletedPayload txnCompletedPayload = OBJECT_MAPPER.readValue(payload.value().toString(), TxnCompletedPayload.class);
        MDC.put("requestId", txnCompletedPayload.getRequestId());
        LOGGER.info("Read from kafka TxnInit : {}", txnCompletedPayload);
        Transaction transaction = txnRepo.findById(txnCompletedPayload.getId()).get();
        if (txnCompletedPayload.getSuccess()) {
            transaction.setStatus(TxnStatusEnum.SUCCESS);
        } else {
            transaction.setStatus(TxnStatusEnum.FAILED);
            transaction.setReason(txnCompletedPayload.getReason());
        }
        txnRepo.save(transaction);
        MDC.clear();
    }

}
