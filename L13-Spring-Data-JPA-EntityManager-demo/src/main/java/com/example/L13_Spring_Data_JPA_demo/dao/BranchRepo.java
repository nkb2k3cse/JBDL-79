package com.example.L13_Spring_Data_JPA_demo.dao;

import com.example.L13_Spring_Data_JPA_demo.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepo extends JpaRepository<Branch,Long> {
}
