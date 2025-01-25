package com.example.L15_minor_project_01.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderItemDto {

    private Long productId;
    private String productName;
    private String productDescription;
    private Integer quantity;
    private Double unitPrice;
    private Double totalPrice;

}
