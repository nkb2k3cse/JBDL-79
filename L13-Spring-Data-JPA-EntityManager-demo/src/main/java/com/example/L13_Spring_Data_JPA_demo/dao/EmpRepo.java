package com.example.L13_Spring_Data_JPA_demo.dao;

import com.example.L13_Spring_Data_JPA_demo.entity.Branch;
import com.example.L13_Spring_Data_JPA_demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);
    List<Employee> findByName(String name);
    List<Employee> findByBranch(Branch branch);
}
