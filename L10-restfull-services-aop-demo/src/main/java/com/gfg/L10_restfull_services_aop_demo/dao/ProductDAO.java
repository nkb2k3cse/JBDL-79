package com.gfg.L10_restfull_services_aop_demo.dao;

import com.gfg.L10_restfull_services_aop_demo.aspect.LogExecutionTime;
import com.gfg.L10_restfull_services_aop_demo.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductDAO {

    private Map<Long, Product> dataStore = new HashMap<>();
    private AtomicLong nextId=new AtomicLong(1l);

    public Product getById(Long id){
        // call DB
        return dataStore.get(id);
    }
    @LogExecutionTime
    public Product create(Product product){
        product.setId(nextId.getAndIncrement());
        dataStore.put(product.getId(),product);
        return product;
    }

    public Product update(Long id, Product product){
        Product exitingProduct = dataStore.get(id);
        if(exitingProduct==null){
            return null;
        }
        exitingProduct.setName(product.getName());
        exitingProduct.setCost(product.getCost());
        return exitingProduct;
    }

    public Product delete(Long id){
        Product exitingProduct = dataStore.get(id);
        if(exitingProduct==null){
            return null;
        }
        dataStore.remove(id);
        return exitingProduct;
    }


    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        for(Map.Entry<Long,Product> entry : dataStore.entrySet()){
            productList.add(entry.getValue());

        }
        return productList;
    }
}
