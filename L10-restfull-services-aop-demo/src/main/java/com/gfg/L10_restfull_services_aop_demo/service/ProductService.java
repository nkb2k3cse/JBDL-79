package com.gfg.L10_restfull_services_aop_demo.service;

import com.gfg.L10_restfull_services_aop_demo.aspect.LogExecutionTime;
import com.gfg.L10_restfull_services_aop_demo.dao.ProductDAO;
import com.gfg.L10_restfull_services_aop_demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    @LogExecutionTime
    public Product getById(Long id){
        return productDAO.getById(id);
    }

    @LogExecutionTime
    public Product create(Product product){
        return productDAO.create(product);
    }

    public Product update(Long id, Product product){
        return productDAO.update(id,product);
    }

    public Product delete(Long id){
        return productDAO.delete(id);
    }

}
