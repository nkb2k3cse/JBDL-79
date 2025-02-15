package com.example.L20_product_app;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

    private Long id;

    private String name;

    private Double cost;

}
