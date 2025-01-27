package com.gfg.L08_spring_boot_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {

    private static Logger LOGGER = LoggerFactory.getLogger(AppController.class);


    @Autowired
    private ProductService productService;

    @Autowired
    private FlightSearchService flightSearchService;



//    public AppController(ProductService productService) {
//        this.productService = productService;
//    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        LOGGER.info("Processing request...");
        LOGGER.
        return productService.getAllProducts();
    }

    @GetMapping("/indigo")
    public String getIndigoData(){
        LOGGER.info("Processing indigo request...");
        return flightSearchService.callIndigoAPIForData();
    }
}
