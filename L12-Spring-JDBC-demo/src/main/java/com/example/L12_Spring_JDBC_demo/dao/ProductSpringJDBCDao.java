package com.example.L12_Spring_JDBC_demo.dao;


import com.example.L12_Spring_JDBC_demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productSpringJDBCDao")
public class ProductSpringJDBCDao implements IProductDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private RowMapper<Product> productRowMapper;

    @Value("${product.query.find.by.id}")
    private String findProdById;

    @Value(("${product.command.create}"))
    private String createProductSQL;



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
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("name",product.getName());
        parameterSource.addValue("cost",product.getCost());
        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(createProductSQL,parameterSource,keyHolder);
        product.setId(keyHolder.getKey().longValue());
        return product;
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
