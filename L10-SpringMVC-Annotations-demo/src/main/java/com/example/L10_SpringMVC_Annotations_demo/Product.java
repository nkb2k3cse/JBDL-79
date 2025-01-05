package com.example.L10_SpringMVC_Annotations_demo;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private Long id;
    private String name;
    private Double cost;
}
