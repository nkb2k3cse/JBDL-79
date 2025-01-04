package com.gfg.L09_Logging_MVC_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private static Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    private List<Product> products = new ArrayList<>();


    public String createProduct( Product product){
        LOGGER.info("Creating Product: {} ",product);
        products.add(product);
        return "Product Added";
    }

    public List<Product> getAll(){
        return products;
    }
}
