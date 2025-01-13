package com.example.L12_Spring_JDBC_demo.dao;


import com.example.L12_Spring_JDBC_demo.entity.Product;

public interface IProductDao {
    public Product getById(Long id);
    public Product create(Product product);
    public Product update(Long id, Product product);
    public Product delete(Long id);


}
