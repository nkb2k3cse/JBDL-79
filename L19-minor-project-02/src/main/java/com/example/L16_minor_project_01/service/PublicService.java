package com.example.L16_minor_project_01.service;

import com.example.L16_minor_project_01.dto.*;
import com.example.L16_minor_project_01.entity.Product;
import com.example.L16_minor_project_01.entity.Role;
import com.example.L16_minor_project_01.entity.User;
import com.example.L16_minor_project_01.repo.ProductRepo;
import com.example.L16_minor_project_01.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class PublicService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private ProductRepo productRepo;


    @Autowired
    private RedisTemplate<String,SearchProductDto> searchProductDtoRedisTemplate;

    public SignUpResponseDto createUser(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setRole(Role.CUSTOMER);
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode("hello"));
        userRepo.save(user);
        // Generate link to reset password valid for 2 min.
        String token = UUID.randomUUID().toString();
        String key = "password:"+token;
        redisTemplate.opsForValue().set(key, userDto.getEmail(),2, TimeUnit.MINUTES);
        String link = "/public/password-reset/"+token;
        SignUpResponseDto responseDto = new SignUpResponseDto();
        responseDto.setLink(link);
        responseDto.setMessage("Use this link to reset your password");
        return responseDto;
    }

    public String resetPassword(PasswordReqDto passwordReqDto, String token){
        String key = "password:"+token;
        String existingEmail = redisTemplate.opsForValue().get(key);
        if(existingEmail == null){
            return "Token expire";
        }
        if(!existingEmail.equals(passwordReqDto.getEmail())){
            return "Email Invalid";
        }
        User user = userRepo.findByEmail(existingEmail);
        user.setPassword(passwordEncoder.encode(passwordReqDto.getNewPassword()));
        userRepo.save(user);
        return "Password Updated";
    }

    public SearchProductDto getProducts(String keyword, Integer pageSize, Integer pageNo){
        /*
        Select name, id, ... FROM Product where name LIKE'%keyword%';
         */
        String key ="search:"+keyword+":"+pageSize+":"+pageNo;
        SearchProductDto searchProductDto = searchProductDtoRedisTemplate.opsForValue().get(key);
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
        searchProductDtoRedisTemplate.opsForValue().set(key,searchProductDto,60, TimeUnit.MINUTES);
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
