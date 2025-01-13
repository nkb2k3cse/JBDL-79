package com.example.L11_Spring_JDBC_demo.dao;


import com.example.L11_Spring_JDBC_demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productSpringJDBCDao")
public class ProductSpringJDBCDao implements IProductDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RowMapper<Product> productRowMapper;

    @Override
    public Product getById(Long id) {
        String sqlQuery = "Select id, name, cost from product where id="+id;
        List<Product> productList = jdbcTemplate.query(sqlQuery,productRowMapper);
        if(productList.isEmpty()){
            return null;
        }
        return productList.get(0);
    }

    @Override
    public Product create(Product product) {
        return null;
    }

    @Override
    public Product update(Long id, Product product) {
        return null;
    }

    @Override
    public Product delete(Long id) {
        return null;
    }
}
