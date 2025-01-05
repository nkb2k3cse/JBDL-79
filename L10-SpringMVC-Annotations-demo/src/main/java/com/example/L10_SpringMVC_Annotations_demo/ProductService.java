package com.example.L10_SpringMVC_Annotations_demo;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private static Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    private List<Product> products = new ArrayList<>();

    @PostConstruct
    public void init(){
        products.add(new Product(1l,"Laptop", 22.2));
        products.add(new Product(2l,"Mouse",100.00));
    }

    public String createProduct( Product product){
        LOGGER.info("Creating Product: {} ",product);
        products.add(product);
        return "Product Added";
    }

    public List<Product> getAll(){
        return products;
    }
}
