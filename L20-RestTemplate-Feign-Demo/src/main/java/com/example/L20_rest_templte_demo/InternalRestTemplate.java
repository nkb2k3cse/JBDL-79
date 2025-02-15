package com.example.L20_rest_templte_demo;

import com.example.L20_rest_templte_demo.dto.ProductDto;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class InternalRestTemplate {

    @Autowired
    private RestTemplate restTemplate;


//    public T postAPICall(Object payload){
//        String reqId = MDC.get("requestId");
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("requestId",reqId);
//        HttpEntity<ProductDto> entity = new HttpEntity(payload,headers);
//        ProductDto response = restTemplate.postForObject(url,entity, ProductDto.class);
//        return response;
//    }

}
