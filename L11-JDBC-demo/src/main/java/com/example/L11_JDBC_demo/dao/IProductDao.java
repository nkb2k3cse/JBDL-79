package com.example.L11_JDBC_demo.dao;

import com.example.L11_JDBC_demo.entity.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public interface IProductDao {
    public Product getById(Long id);
    public Product create(Product product);
    public Product update(Long id, Product product);
    public Product delete(Long id);


}
