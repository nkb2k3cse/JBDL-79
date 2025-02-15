package com.example.L20_Spring_Boot_Actuator_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyAppHealthIndicator implements HealthIndicator {

    private static Logger LOGGER = LoggerFactory.getLogger(MyAppHealthIndicator.class);

    @Override
    public Health health() {
        int errorCode = check();
        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }
    private int check() {
        // perform some specific check
        // connectivity to redis/mySQL/Kafka or other service
        int status = 0;
        LOGGER.info("External Dependency Status: {}",status);
        return status;
    }
}


