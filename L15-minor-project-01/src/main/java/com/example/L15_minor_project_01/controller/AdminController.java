package com.example.L15_minor_project_01.controller;

import com.example.L15_minor_project_01.dto.CreateCompanyRequestDto;
import com.example.L15_minor_project_01.dto.CreateCompanyResponseDto;
import com.example.L15_minor_project_01.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private static Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @PostMapping("/company")
    public ResponseEntity<CreateCompanyResponseDto> createCompany(@RequestBody CreateCompanyRequestDto createCompanyRequestDto){
        CreateCompanyResponseDto responseDto = adminService.createCompany(createCompanyRequestDto);
        return ResponseEntity.ok(responseDto);
    }



}
