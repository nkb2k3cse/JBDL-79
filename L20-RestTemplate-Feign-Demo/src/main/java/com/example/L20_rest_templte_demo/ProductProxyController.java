package com.example.L20_rest_templte_demo;

import com.example.L20_rest_templte_demo.client.ProductServiceClient;
import com.example.L20_rest_templte_demo.dto.ProductDto;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/proxy/product")
public class ProductProxyController {

    private static Logger LOGGER = LoggerFactory.getLogger(ProductProxyController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductServiceClient productServiceClient;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto product, @RequestHeader(required = false) String requestId){
        LOGGER.info("Processing createProduct Req: {}",product);
//        String url = "http://localhost:8080/product";
//        String reqId = MDC.get("requestId");
//        HttpHeaders  headers = new HttpHeaders();
//        headers.add("requestId",reqId);
//        HttpEntity<ProductDto> entity = new HttpEntity(product,headers);
//        ProductDto response = restTemplate.postForObject(url,entity, ProductDto.class);
        String reqId = MDC.get("requestId");
        ProductDto response = productServiceClient.createProduct(product,reqId).getBody();
        LOGGER.info("Created Product: {}",response);
        return ResponseEntity.ok(response);
    }




    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long id){
//        String url = "http://localhost:8080/product/"+id;
        LOGGER.info("Making call to actual ProductService for id {}",id);
        String reqId = MDC.get("requestId");
//        HttpHeaders  headers = new HttpHeaders();
//        headers.add("requestId",reqId);
//        JsonNode response  = restTemplate.getForObject(url,JsonNode.class,headers);
        ProductDto response = productServiceClient.getProduct(id,reqId).getBody();
        return ResponseEntity.ok(response);
    }


}
/*
InternalRestTemplate{
restTemplate
}
 */