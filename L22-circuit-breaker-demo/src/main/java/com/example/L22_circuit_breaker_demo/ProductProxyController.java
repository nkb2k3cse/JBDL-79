package com.example.L22_circuit_breaker_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/proxy")
public class ProductProxyController {

    private static Logger LOGGER = LoggerFactory.getLogger(ProductProxyController.class);

    @Autowired
    private ProductServiceClient productServiceClient;

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @GetMapping("/{id}")
    ResponseEntity<ProductDto> getProductProxy(@PathVariable Long id) {
        LOGGER.info("Calling actual ProductApp to get a Product");
        String requestId = MDC.get("requestId");
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("cb01");
        //ProductDto productDto = productServiceClient.getProduct(id,requestId);
        ProductDto productDto = circuitBreaker.run(() -> productServiceClient.getProduct(id,requestId),throwable -> fallbackMethodForGetProduct());
        return ResponseEntity.ok(productDto);
    }

    public ProductDto fallbackMethodForGetProduct(){
        return new ProductDto(1l,"Dummy Product", 1000.00);
    }
}





