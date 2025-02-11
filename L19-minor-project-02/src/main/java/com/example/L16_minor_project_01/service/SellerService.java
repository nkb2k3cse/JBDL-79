package com.example.L16_minor_project_01.service;

import com.example.L16_minor_project_01.dto.CreateProductRequestDto;
import com.example.L16_minor_project_01.dto.CreateProductResponseDto;
import com.example.L16_minor_project_01.dto.OrderDetailDto;
import com.example.L16_minor_project_01.entity.Category;
import com.example.L16_minor_project_01.entity.Company;
import com.example.L16_minor_project_01.entity.Product;
import com.example.L16_minor_project_01.entity.User;
import com.example.L16_minor_project_01.exception.CategoryDoesNotExistException;
import com.example.L16_minor_project_01.exception.CompanyDoesNotExistException;
import com.example.L16_minor_project_01.repo.CategoryRepo;
import com.example.L16_minor_project_01.repo.CompanyRepo;
import com.example.L16_minor_project_01.repo.OrderRepo;
import com.example.L16_minor_project_01.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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

    @Autowired
    private OrderRepo orderRepo;

    public CreateProductResponseDto createProduct(CreateProductRequestDto requestDto) throws CompanyDoesNotExistException, CategoryDoesNotExistException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Company company = companyRepo.findById(user.getCompany().).orElseThrow(
//                () ->  new CompanyDoesNotExistException("CompanyDoesNotExistException"));
        Category category = categoryRepo.findById(requestDto.getCatId()).orElseThrow(
                () ->  new CategoryDoesNotExistException("CategoryDoesNotExistException"));
        Product product = new Product();
        product.setCategory(category);
        product.setCompany(user.getCompany());
        product.setName(requestDto.getName());
        product.setDescription(requestDto.getDescription());
        product.setStock(requestDto.getStock());
        product.setPrice(requestDto.getPrice());
        product.setActive(requestDto.getActive());

        product = productRepo.save(product);
        CreateProductResponseDto responseDto = new CreateProductResponseDto();
        responseDto.setProductId(product.getId());
        responseDto.setMsg("Product Created!!");
        return responseDto;
    }

    public List<CreateProductResponseDto> createProductBulk(List<CreateProductRequestDto> listDtos) throws CompanyDoesNotExistException, CategoryDoesNotExistException {
        List<Product> products = new ArrayList<>();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        for(CreateProductRequestDto requestDto: listDtos){
//            Company company = companyRepo.findById(requestDto.getCompanyId()).orElseThrow(
//                    () ->  new CompanyDoesNotExistException("CompanyDoesNotExistException"));
            Category category = categoryRepo.findById(requestDto.getCatId()).orElseThrow(
                    () ->  new CategoryDoesNotExistException("CategoryDoesNotExistException"));
            Product product = new Product();
            product.setCategory(category);
            product.setCompany(user.getCompany());
            product.setName(requestDto.getName());
            product.setDescription(requestDto.getDescription());
            product.setStock(requestDto.getStock());
            product.setPrice(requestDto.getPrice());
            product.setActive(requestDto.getActive());
            products.add(product);
        }

        List<Product> createdProducts = productRepo.saveAll(products);
        List<CreateProductResponseDto> responseDtos = new ArrayList<>();
        for(Product product : createdProducts){
            CreateProductResponseDto responseDto = new CreateProductResponseDto();
            responseDto.setProductId(product.getId());
            responseDto.setMsg("Product Created!!");
            responseDtos.add(responseDto);
        }
        return responseDtos;
    }


    public List<OrderDetailDto> getPendingOrders(){
        return null;
    }
}
