package com.example.L16_minor_project_01.repo;

import com.example.L16_minor_project_01.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

    List<Product> findByNameLike(String name);
    Page<Product> findByNameContaining(String name, Pageable pageable);
}
