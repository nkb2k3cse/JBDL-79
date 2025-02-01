package com.example.L16_UTandITdemo.repo;


import com.example.L16_UTandITdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);

    Employee findByEmailAndName(String email, String name);
}
