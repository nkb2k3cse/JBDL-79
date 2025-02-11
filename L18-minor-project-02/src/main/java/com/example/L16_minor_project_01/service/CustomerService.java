package com.example.L16_minor_project_01.service;

import com.example.L16_minor_project_01.dto.*;
import com.example.L16_minor_project_01.entity.*;
import com.example.L16_minor_project_01.exception.NotFoundException;
import com.example.L16_minor_project_01.repo.OrderRepo;
import com.example.L16_minor_project_01.repo.ProductRepo;
import com.example.L16_minor_project_01.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class CustomerService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RedisTemplate<String,SearchProductDto> redisTemplate;

    public OrderDetailDto addToOrder(AddToOrderDto addToOrderDto) throws NotFoundException {
        Product product = productRepo.findById(addToOrderDto.getProductId()).orElseThrow(()-> new NotFoundException("Product Does not exist"));
        User userRequested = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepo.findById(userRequested.getId()).orElseThrow(()-> new NotFoundException("User Does not exist"));
        List<Order> orderList = orderRepo.findByStatusAndUser(OrderStatus.DRAFT,user);
        Order existingOrder;
        if(!orderList.isEmpty()){
            existingOrder = orderList.get(0);
        }
        else {
            existingOrder = Order.builder()
                    .status(OrderStatus.DRAFT)
                    .totalAmount(0.0)
                    .user(user)
                    .company(product.getCompany())
                    .orderItems(new ArrayList<>())
                    .build();
        }
        OrderItem orderItem = OrderItem.builder()
                .order(existingOrder)
                .price(product.getPrice())
                .quantity(addToOrderDto.getQuantity())
                .product(product)
                .build();
        existingOrder.getOrderItems().add(orderItem);
        //Pricing
        double totalItemsPrice = product.getPrice() * orderItem.getQuantity();
        existingOrder.setTotalAmount(existingOrder.getTotalAmount() + totalItemsPrice);
        existingOrder = orderRepo.save(existingOrder);

        OrderDetailDto orderDetailDto = new OrderDetailDto();
        orderDetailDto.setOrderId(existingOrder.getId());
        orderDetailDto.setOrderTotalPrice(existingOrder.getTotalAmount());
        List<OrderItemDto> orderItemDtoList = new ArrayList<>();
        for(OrderItem orderItem1 : existingOrder.getOrderItems()){
            orderItemDtoList.add(mapOrderItemToDto(orderItem1));
        }
        orderDetailDto.setOrderItemList(orderItemDtoList);
        return orderDetailDto;
    }

    private OrderItemDto mapOrderItemToDto(OrderItem orderItem){
        OrderItemDto dto = new OrderItemDto();
        dto.setQuantity(orderItem.getQuantity());
        dto.setProductId(orderItem.getProduct().getId());
        dto.setProductName(orderItem.getProduct().getName());
        dto.setProductDescription(orderItem.getProduct().getDescription());
        dto.setUnitPrice(orderItem.getProduct().getPrice());
        dto.setTotalPrice(orderItem.getProduct().getPrice() * orderItem.getQuantity());
        return dto;
    }

    public SearchProductDto getProducts(String keyword, Integer pageSize, Integer pageNo){
        /*
        Select name, id, ... FROM Product where name LIKE'%keyword%';
         */
        String key ="search:"+keyword+":"+pageSize+":"+pageNo;
        SearchProductDto searchProductDto = redisTemplate.opsForValue().get(key);
        if(searchProductDto != null){
            return searchProductDto;
        }
        searchProductDto = new SearchProductDto();
        Pageable pageable = Pageable.ofSize(pageSize)
                .withPage(pageNo);
        Page<Product> productPage = productRepo.findByNameContaining(keyword,pageable);
        List<Product> productList = productPage.stream().toList();
        List<ProductDto> productDtos = new ArrayList<>();
        for(Product product : productList ){
            productDtos.add(mapProductToDto(product));
        }
        searchProductDto.setProductDtoList(productDtos);
        searchProductDto.setTotalRows(productPage.getTotalElements());
        searchProductDto.setTotalPages(productPage.getTotalPages());
        //put data in redis
        redisTemplate.opsForValue().set(key,searchProductDto,60, TimeUnit.MINUTES);
        return searchProductDto;
    }

    private ProductDto mapProductToDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        return productDto;
    }

}
