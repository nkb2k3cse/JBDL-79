package com.example.L19_OAuth_demo;

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


//    @GetMapping("/{id}")
//    public ResponseEntity<JsonNode> getBlog(@PathVariable Long id){
//        String url = "https://jsonplaceholder.typicode.com/posts/"+id;
//        JsonNode jsonNode = restTemplate.getForObject(url,JsonNode.class);
//        return ResponseEntity.ok(jsonNode);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogDto> getBlog(@PathVariable Long id){
        String url = "https://jsonplaceholder.typicode.com/posts/"+id;
        BlogDto blogDto = restTemplate.getForObject(url,BlogDto.class);
        blogDto.setServerDateTime(new Date());
        return ResponseEntity.ok(blogDto);
    }
}
