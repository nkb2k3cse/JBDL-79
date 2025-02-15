package com.example.L20_rest_templte_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class L20RestTemplateDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(L20RestTemplateDemoApplication.class, args);
	}

}
