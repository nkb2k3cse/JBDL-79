package com.example.L20_rest_templte_demo;

import com.example.L20_rest_templte_demo.client.BlogServiceClient;
import com.example.L20_rest_templte_demo.dto.BlogDto;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BlogServiceClient blogServiceClient;


//    @GetMapping("/{id}")
//    public ResponseEntity<JsonNode> getBlog(@PathVariable Long id){
//        String url = "https://jsonplaceholder.typicode.com/posts/"+id;
//        JsonNode response  = restTemplate.getForObject(url,JsonNode.class);
//        return ResponseEntity.ok(response);
//    }


    @GetMapping("/{id}")
    public ResponseEntity<BlogDto> getBlog(@PathVariable Long id){
        BlogDto blogDto = blogServiceClient.getBlogById(id);
        return ResponseEntity.ok(blogDto);
    }

}

