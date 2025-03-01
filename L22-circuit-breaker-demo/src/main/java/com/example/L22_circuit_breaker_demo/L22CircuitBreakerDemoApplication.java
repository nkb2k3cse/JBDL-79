package com.example.L22_circuit_breaker_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class L22CircuitBreakerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(L22CircuitBreakerDemoApplication.class, args);
	}

}
