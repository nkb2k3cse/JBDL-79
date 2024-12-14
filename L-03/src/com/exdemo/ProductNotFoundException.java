package com.exdemo;

public class ProductNotFoundException extends Exception{

    private String productId;

    public ProductNotFoundException(String message, String productId) {
        super(message);
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
}
