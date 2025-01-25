package com.example.L15_minor_project_01.dto;

import com.example.L15_minor_project_01.entity.OrderItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
public class OrderDetailDto {

    private Long orderId;

    private List<OrderItemDto> orderItemList;

    private Double orderTotalPrice;
}
