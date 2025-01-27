package com.example.L14_minor_project_01.controller;

import com.example.L14_minor_project_01.dto.CreateProductRequestDto;
import com.example.L14_minor_project_01.dto.CreateProductResponseDto;
import com.example.L14_minor_project_01.dto.ProductListOutputDto;
import com.example.L14_minor_project_01.entity.Product;
import com.example.L14_minor_project_01.exception.CategoryDoesNotExistException;
import com.example.L14_minor_project_01.exception.CompanyDoesNotExistException;
import com.example.L14_minor_project_01.exception.ProductNotFoundException;
import com.example.L14_minor_project_01.service.SellerService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping("/product")
    public ResponseEntity<CreateProductResponseDto> createProduct(@RequestBody @Valid CreateProductRequestDto requestDto) throws CompanyDoesNotExistException, CategoryDoesNotExistException {
        CreateProductResponseDto responseDto = sellerService.createProduct(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<CreateProductResponseDto> updateProduct(@PathVariable Long id, @RequestBody @Valid CreateProductRequestDto requestDto) throws CompanyDoesNotExistException, CategoryDoesNotExistException, ProductNotFoundException {
        CreateProductResponseDto responseDto = sellerService.updateProduct(id,requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @Operation(summary = "Gives all Products ",
            description = "Pagination support to follow soon...")
    @GetMapping("/products")
    public ResponseEntity<List<ProductListOutputDto>> getProducts(){
        return ResponseEntity.ok().body(sellerService.getProducts());
    }
}
