package com.example.L13_Spring_Data_JPA_demo.controller;



import com.example.L13_Spring_Data_JPA_demo.entity.Product;
import com.example.L13_Spring_Data_JPA_demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id){
        Product product = productService.getById(id);
        if(product == null){
            //set response code 404
            return ResponseEntity.notFound().build();// Builder Design Pattern
        }
        return ResponseEntity.ok(product);
    }

    @GetMapping("/byname")
    public ResponseEntity<List<Product>> getProductByName(@RequestParam String name){
        List<Product> productList = productService.getByName(name);
        if(productList.isEmpty()){
            //set response code 404
            return ResponseEntity.notFound().build();// Builder Design Pattern
        }
        return ResponseEntity.ok(productList);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) throws URISyntaxException {
        //long start = System.currentTimeMillis();
        if(product.getName() == null ||"".equals( product.getName())){
            return ResponseEntity.badRequest().build();
        }
        Product createdProduct = productService.create(product);
        URI uri = new URI("http://localhost:8080/product/"+createdProduct.getId());
        //long end = System.currentTimeMillis();
        return ResponseEntity.created(uri).build();
//        return ResponseEntity.ok(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product){
        Product updatedProduct = productService.update(id,product);
        if(updatedProduct==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id){
        Product deletedProduct = productService.delete(id);
        if(deletedProduct==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deletedProduct);
    }




}
