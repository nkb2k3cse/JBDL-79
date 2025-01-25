package com.example.L15_minor_project_01.controller;

import com.example.L15_minor_project_01.dto.AddToOrderDto;
import com.example.L15_minor_project_01.dto.OrderDetailDto;
import com.example.L15_minor_project_01.dto.ProductDto;
import com.example.L15_minor_project_01.dto.SearchProductDto;
import com.example.L15_minor_project_01.exception.NotFoundException;
import com.example.L15_minor_project_01.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/product")
    public ResponseEntity<SearchProductDto> searchProducts(@RequestParam String keyword, @RequestParam Integer pageSize, @RequestParam Integer pageNo){
        SearchProductDto searchProductDto = customerService.getProducts(keyword,pageSize,pageNo);
        return ResponseEntity.ok(searchProductDto);
    }

    @PostMapping("/addToOrder")
    public ResponseEntity<OrderDetailDto> addToOrder(@RequestBody AddToOrderDto addToOrderDto) throws NotFoundException {
        OrderDetailDto orderDetailDto = customerService.addToOrder(addToOrderDto);
        return ResponseEntity.ok(orderDetailDto);
    }
}
