package com.example.L12_Spring_Data_JPA_demo.dao;

import com.example.L12_Spring_Data_JPA_demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);
}