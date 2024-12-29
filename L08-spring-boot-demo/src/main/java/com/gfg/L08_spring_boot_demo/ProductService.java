package com.gfg.L08_spring_boot_demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService {

    private List<Product> dataStore;

    public ProductService() {
        dataStore = new ArrayList<>();
        dataStore.add(new Product("Laptop",50000.00));
        dataStore.add(new Product("Mobile",6000.00));

    }

    public List<Product> getAllProducts(){
        return dataStore;
    }
}
