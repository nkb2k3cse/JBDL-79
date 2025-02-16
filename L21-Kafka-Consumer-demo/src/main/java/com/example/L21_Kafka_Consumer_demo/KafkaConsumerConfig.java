package com.example.L21_Kafka_Consumer_demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class KafkaConsumerConfig {

    private static Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerConfig.class);

    @Autowired
    private JavaMailSender javaMailSender;

    private ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "jbdl3", groupId = "app")
    public void consumeData(Object payload){
        String data = (String) ((ConsumerRecord)payload).value();
        LOGGER.info("Data Consuming payload: {}",payload);
        LOGGER.info("Data Consuming Value: {}",data);
    }


    @KafkaListener(topics = "emailTopic", groupId = "emailApp")
    public void consumeDataForEmail(Object payload) throws JsonProcessingException {
        String jsonValue = (String) ((ConsumerRecord)payload).value();
        EmailRequest emailRequest =  objectMapper.readValue(jsonValue,EmailRequest.class);
        LOGGER.info("Data Consuming payload: {}",payload);
        LOGGER.info("Data Consuming Value: {}",payload);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("sk.email.service@gmail.com");
        simpleMailMessage.setSubject(emailRequest.getSubject());
        simpleMailMessage.setText(emailRequest.getBody());
        simpleMailMessage.setCc(emailRequest.getCc());
        simpleMailMessage.setTo(emailRequest.getToEmail());
        javaMailSender.send(simpleMailMessage);
    }



}
