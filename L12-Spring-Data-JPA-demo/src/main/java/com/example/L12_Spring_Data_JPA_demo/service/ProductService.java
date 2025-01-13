package com.example.L12_Spring_Data_JPA_demo.service;

import com.example.L12_Spring_Data_JPA_demo.dao.ProductRepo;
import com.example.L12_Spring_Data_JPA_demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;


    public Product getById(Long id){
        return productRepo.findById(id).get();
    }


    public List<Product> getByName(String name){
        return productRepo.findByName(name);
    }



    public Product create(Product product){
        return productRepo.save(product);
    }

    public Product update(Long id, Product product){
        product.setId(id);
        return productRepo.save(product);
    }

    public Product delete(Long id){
        Product product = productRepo.getById(id);
        Product productCopy = new Product(product.getId(),product.getName(),product.getCost());
        productRepo.delete(product);
        return productCopy;
    }

}
