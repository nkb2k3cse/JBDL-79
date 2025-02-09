package com.example.L16_minor_project_01.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddToOrderDto {
    //private Long orderId;
    private Long productId;
    private Integer quantity;
}
