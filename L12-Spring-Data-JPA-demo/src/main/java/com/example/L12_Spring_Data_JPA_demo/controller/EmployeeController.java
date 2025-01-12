package com.example.L12_Spring_Data_JPA_demo.controller;

import com.example.L12_Spring_Data_JPA_demo.entity.Employee;
import com.example.L12_Spring_Data_JPA_demo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmpService empService;

    @GetMapping("/all")
    public List<Employee> getAllEmp(){
        List<Employee> employees = empService.getAll();
        return employees;
    }

    @GetMapping("/byEmail")
    public Employee getByEmail(@RequestParam String email){
        Employee employee = empService.getByEmail(email);
        return employee;
    }
}
