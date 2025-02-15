package com.example.L20_rest_templte_demo.client;

import com.example.L20_rest_templte_demo.dto.BlogDto;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "blogs",url = "https://jsonplaceholder.typicode.com")
public interface BlogServiceClient {

    @GetMapping("/posts/{id}")
    BlogDto getBlogById(@PathVariable Long id);
}
