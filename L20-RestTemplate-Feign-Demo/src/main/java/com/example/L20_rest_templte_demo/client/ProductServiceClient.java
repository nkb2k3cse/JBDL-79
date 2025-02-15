package com.example.L20_rest_templte_demo.client;

import com.example.L20_rest_templte_demo.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductServiceClient {

    @PostMapping("/product")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto product, @RequestHeader(required = false) String requestId);


    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long id,  @RequestHeader(required = false) String requestId);

}
