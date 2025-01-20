package com.example.L13_Spring_Data_JPA_demo.controller;

import com.example.L13_Spring_Data_JPA_demo.dto.EmployeeDetailReq;
import com.example.L13_Spring_Data_JPA_demo.entity.Employee;
import com.example.L13_Spring_Data_JPA_demo.exceptions.AdhaarNotVerifiedException;
import com.example.L13_Spring_Data_JPA_demo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Employee> getByEmail(@RequestParam String email){
        Employee employee = empService.findByEmail(email);
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<Long> createEmp(@RequestBody EmployeeDetailReq employeeDetailReq) throws AdhaarNotVerifiedException {
        Long id = empService.createEmp(employeeDetailReq);
        return ResponseEntity.ok(id);
    }
}
