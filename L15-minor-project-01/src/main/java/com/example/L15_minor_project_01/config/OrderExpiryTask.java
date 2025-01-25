package com.example.L15_minor_project_01.config;

import com.example.L15_minor_project_01.repo.OrderRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class OrderExpiryTask {

    private Logger LOGGER = LoggerFactory.getLogger(OrderExpiryTask.class);

    @Autowired
    private OrderRepo orderRepo;


    @Scheduled(fixedDelay = 5000)
    public void markOrderAsExpired(){
        LOGGER.info("Marking ORDERs as Expired");
        /*
        Fetch Orders in PLACED status lastUpdate was 7 days ago
         */
    }
}
