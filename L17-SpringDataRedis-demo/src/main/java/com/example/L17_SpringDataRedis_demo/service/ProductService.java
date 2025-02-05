package com.example.L17_SpringDataRedis_demo.service;

import com.example.L17_SpringDataRedis_demo.entity.Product;
import com.example.L17_SpringDataRedis_demo.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Service
public class ProductService {


    @Autowired
    private ProductRepo productRepo;

//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RedisTemplate<String, Product> productredisTemplate;

    public Product getById(Long id){
        //Check in cache
        String key = "product:"+id;
        //Product product = (Product) redisTemplate.opsForValue().get(key);
        Product product = productredisTemplate.opsForValue().get(key);
        if(product == null){
            //Cache Miss
            product = productRepo.findById(id).get();
            productredisTemplate.opsForValue().set(key,product,5, TimeUnit.MINUTES);
        }
        return product;
    }

    public Long createProduct(Product product){
        product = productRepo.save(product);
        return product.getId();
    }
}
