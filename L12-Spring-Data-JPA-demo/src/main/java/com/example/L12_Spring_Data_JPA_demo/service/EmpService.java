package com.example.L12_Spring_Data_JPA_demo.service;

import com.example.L12_Spring_Data_JPA_demo.dao.EmpRepo;
import com.example.L12_Spring_Data_JPA_demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    private EmpRepo empRepo;

    public List<Employee> getAll(){
        return empRepo.findAll();
    }

    public Employee getByEmail(String email){
        return empRepo.findByEmail(email);
    }
}
