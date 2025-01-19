package com.example.L14_minor_project_01.controller;

import com.example.L14_minor_project_01.dto.CreateCompanyRequestDto;
import com.example.L14_minor_project_01.dto.CreateCompanyResponseDto;
import com.example.L14_minor_project_01.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @PostMapping("/company")
    public ResponseEntity<CreateCompanyResponseDto> createCompany(@RequestBody CreateCompanyRequestDto createCompanyRequestDto){
        CreateCompanyResponseDto responseDto = adminService.createCompany(createCompanyRequestDto);
        return ResponseEntity.ok(responseDto);
    }


}
