package com.example.L14_minor_project_01.service;

import com.example.L14_minor_project_01.dto.CreateProductRequestDto;
import com.example.L14_minor_project_01.dto.CreateProductResponseDto;
import com.example.L14_minor_project_01.dto.ProductListOutputDto;
import com.example.L14_minor_project_01.entity.Category;
import com.example.L14_minor_project_01.entity.Company;
import com.example.L14_minor_project_01.entity.Product;
import com.example.L14_minor_project_01.exception.CategoryDoesNotExistException;
import com.example.L14_minor_project_01.exception.CompanyDoesNotExistException;
import com.example.L14_minor_project_01.exception.ProductNotFoundException;
import com.example.L14_minor_project_01.repo.CategoryRepo;
import com.example.L14_minor_project_01.repo.CompanyRepo;
import com.example.L14_minor_project_01.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SellerService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    public CreateProductResponseDto createProduct(CreateProductRequestDto requestDto) throws CompanyDoesNotExistException, CategoryDoesNotExistException {
        Company company = companyRepo.findById(requestDto.getCompanyId()).orElseThrow(
                () -> new CompanyDoesNotExistException("CompanyDoesNotExistException"));
        Category category = categoryRepo.findById(requestDto.getCatId()).orElseThrow(
                () -> new CategoryDoesNotExistException("CategoryDoesNotExistException"));
        Product product = new Product();
        product.setCategory(category);
        product.setCompany(company);
        product.setName(requestDto.getName());
        product.setDescription(requestDto.getDescription());
        product.setStock(requestDto.getStock());
        product.setPrice(requestDto.getPrice());
        product.setActive(requestDto.getActive());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());


        product = productRepo.save(product);
        CreateProductResponseDto responseDto = new CreateProductResponseDto();
        responseDto.setProductId(product.getId());
        responseDto.setMsg("Product Created!!");
        return responseDto;

    }

    public CreateProductResponseDto updateProduct(Long id, CreateProductRequestDto requestDto) throws ProductNotFoundException {

        Product product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException());

        product.setStock(requestDto.getStock());
        product.setPrice(requestDto.getPrice());
        product.setActive(requestDto.getActive());
        product.setUpdatedAt(LocalDateTime.now());
        product.setName(requestDto.getName());

        productRepo.save(product);

        CreateProductResponseDto productResponseDto = new CreateProductResponseDto();
        productResponseDto.setProductId(id);
        productResponseDto.setMsg("product updated");
        return productResponseDto;

    }

    public List<ProductListOutputDto> getProducts() {

        List<Product> products = productRepo.findAll();

        List<ProductListOutputDto> productsOutputList = new ArrayList<>();

        for (Product product : products) {
            ProductListOutputDto productListOutputDto = new ProductListOutputDto();

            productListOutputDto.setId(product.getId());
            productListOutputDto.setName(product.getName());


            productsOutputList.add(productListOutputDto);

        }


        return productsOutputList;
    }
}
