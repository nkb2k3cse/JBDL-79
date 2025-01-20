package com.example.L14_minor_project_01.controller;

import com.example.L14_minor_project_01.dto.CreateProductRequestDto;
import com.example.L14_minor_project_01.dto.CreateProductResponseDto;
import com.example.L14_minor_project_01.exception.CategoryDoesNotExistException;
import com.example.L14_minor_project_01.exception.CompanyDoesNotExistException;
import com.example.L14_minor_project_01.service.SellerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
