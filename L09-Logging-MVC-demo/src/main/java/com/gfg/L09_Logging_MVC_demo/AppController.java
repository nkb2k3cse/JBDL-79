package com.gfg.L09_Logging_MVC_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class AppController {

    private static Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    @Autowired(required = false)
    private GfgService gfgService;

    @Autowired
    private ProductService productService;


    @GetMapping("/hello")
    public String getMsg(@RequestParam(value = "n", required = false) String name){
        return "Hello "+name+" from :"+Thread.currentThread().getName();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Long id, @RequestParam String name){
        return new Product(id,name);
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getAll();
    }

    @PostMapping("/product")
    public String createProduct(@RequestBody  Product product, @RequestHeader String clientId, @RequestHeader String requestId ){
        LOGGER.info("Request Processing...");
        String response = productService.createProduct(product);
        MDC.clear();
        return response;
    }



    @GetMapping("/sessions")
    private String sessions(){
        return gfgService.getSessionDetails();
    }
}
