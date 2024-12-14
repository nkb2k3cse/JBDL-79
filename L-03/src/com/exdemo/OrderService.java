package com.exdemo;

public class OrderService {


    public void placeOrder(String productId) throws ProductNotFoundException {
        /*



         */
        if(productId.equals("1234")){
            throw new ProductNotFoundException("Product Does not Exist",productId);
        }
    }
}
