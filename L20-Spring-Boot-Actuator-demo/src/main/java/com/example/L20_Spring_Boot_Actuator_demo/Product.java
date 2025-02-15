package com.example.L20_Spring_Boot_Actuator_demo;

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
