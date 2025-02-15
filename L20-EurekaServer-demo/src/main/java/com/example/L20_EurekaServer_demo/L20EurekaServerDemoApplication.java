package com.example.L20_EurekaServer_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class L20EurekaServerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(L20EurekaServerDemoApplication.class, args);
	}

}
