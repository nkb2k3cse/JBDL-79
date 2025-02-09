package com.example.L16_minor_project_01.controller;

import com.example.L16_minor_project_01.dto.PasswordReqDto;
import com.example.L16_minor_project_01.dto.SearchProductDto;
import com.example.L16_minor_project_01.dto.SignUpResponseDto;
import com.example.L16_minor_project_01.dto.UserDto;
import com.example.L16_minor_project_01.service.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {


    @Autowired
    private PublicService publicService;

    @PostMapping("/signup")
    ResponseEntity<SignUpResponseDto> createCustomerUser(@RequestBody  UserDto userDto){
        SignUpResponseDto responseDto = publicService.createUser(userDto);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/password-reset/{token}")
    ResponseEntity<String> resetPassword(@RequestBody PasswordReqDto passwordReqDto, @PathVariable String token){
        String response = publicService.resetPassword(passwordReqDto,token);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/product")
    public ResponseEntity<SearchProductDto> searchProducts(@RequestParam String keyword, @RequestParam Integer pageSize, @RequestParam Integer pageNo){
        SearchProductDto searchProductDto = publicService.getProducts(keyword,pageSize,pageNo);
        return ResponseEntity.ok(searchProductDto);
    }
}
