package com.gfg.annotations;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("smsGatewayService")
@Scope("prototype")
public class SMSGatewayService {

    public void sendSMS(String msg){
        System.out.println("Sending:"+msg);
    }
}
