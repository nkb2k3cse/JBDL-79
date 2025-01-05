package com.example.L10_SpringMVC_Annotations_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.gfg.payment, com.example.L10_SpringMVC_Annotations_demo")
public class L10SpringMvcAnnotationsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(L10SpringMvcAnnotationsDemoApplication.class, args);
	}

}
