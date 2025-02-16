package com.example.L21_Kafka_Consumer_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class L21KafkaConsumerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(L21KafkaConsumerDemoApplication.class, args);
	}

}
