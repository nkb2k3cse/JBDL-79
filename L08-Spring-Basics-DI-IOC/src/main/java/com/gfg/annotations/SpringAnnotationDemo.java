package com.gfg.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotationDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.gfg.annotations");
        NotificationService notificationService1 = applicationContext.getBean("notificationService", NotificationService.class);
        NotificationService notificationService2 = applicationContext.getBean("notificationService", NotificationService.class);
        System.out.println(notificationService1 == notificationService2);
        notificationService1.sendNotification("OTP 0898");

        SMSGatewayService smsGatewayService = applicationContext.getBean("smsGatewayService", SMSGatewayService.class);
        System.out.println(smsGatewayService == notificationService1.getSmsGatewayService());

//        NotificationService notificationServiceObj1 = new NotificationService(smsGatewayService);
//        System.out.println(notificationService1 == notificationServiceObj1);
    }
}
