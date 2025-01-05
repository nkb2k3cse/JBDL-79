package com.gfg.payment;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String doPayment(Double amount){
        return "Payment completed for "+amount;
    }
}
