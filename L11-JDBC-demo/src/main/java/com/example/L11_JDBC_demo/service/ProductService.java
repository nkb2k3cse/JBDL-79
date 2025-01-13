package com.example.L11_JDBC_demo.service;

import com.example.L11_JDBC_demo.dao.IProductDao;
import com.example.L11_JDBC_demo.dao.ProductDAO;
import com.example.L11_JDBC_demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    @Qualifier("productJDBCDAO")
    private IProductDao iproductDAO;


    public Product getById(Long id){
        return iproductDAO.getById(id);
    }


    public Product create(Product product){
        return iproductDAO.create(product);
    }

    public Product update(Long id, Product product){
        return iproductDAO.update(id,product);
    }

    public Product delete(Long id){
        return iproductDAO.delete(id);
    }

}
