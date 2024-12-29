package com.gfg.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {

    @Autowired
    private SMSGatewayService smsGatewayService;


//    public NotificationService(SMSGatewayService smsGatewayService) {
//        System.out.println("Constructor Injection");
//        this.smsGatewayService = smsGatewayService;
//    }
//
//    public NotificationService() {
//        System.out.println("Constructor Execution");
//    }

    public void sendNotification(String msg){
        smsGatewayService.sendSMS(msg);
    }

    public SMSGatewayService getSmsGatewayService() {
        return smsGatewayService;
    }


//    public void setSmsGatewayService(SMSGatewayService smsGatewayService) {
//        System.out.println("Setter Injection");
//        this.smsGatewayService = smsGatewayService;
//    }
}
