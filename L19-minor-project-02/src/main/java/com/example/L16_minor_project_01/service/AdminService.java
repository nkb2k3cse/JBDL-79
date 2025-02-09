package com.example.L16_minor_project_01.service;

import com.example.L16_minor_project_01.dto.CreateCompanyRequestDto;
import com.example.L16_minor_project_01.dto.CreateCompanyResponseDto;
import com.example.L16_minor_project_01.dto.UserDto;
import com.example.L16_minor_project_01.entity.Company;
import com.example.L16_minor_project_01.entity.Role;
import com.example.L16_minor_project_01.entity.User;
import com.example.L16_minor_project_01.repo.CompanyRepo;
import com.example.L16_minor_project_01.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class AdminService {

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public CreateCompanyResponseDto createCompany(CreateCompanyRequestDto requestDto){
        Company company = Company.builder()
                .active(true)
                .name(requestDto.getName())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        UserDto userDto = requestDto.getPrimaryUser();
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setRole(Role.SELLER);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        company.setUser(user);
        user.setCompany(company);
        user =userRepo.save(user);
        companyRepo.save(company);

        CreateCompanyResponseDto responseDto = new CreateCompanyResponseDto();
        responseDto.setCompanyId(company.getId());
        responseDto.setUserId(user.getId());
        responseDto.setMsg("Company Created!!");
        return responseDto;
    }
}
