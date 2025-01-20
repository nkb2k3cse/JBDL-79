package com.example.L13_Spring_Data_JPA_demo.controller;

import com.example.L13_Spring_Data_JPA_demo.dao.BranchRepo;
import com.example.L13_Spring_Data_JPA_demo.entity.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private BranchRepo branchRepo;

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<Branch> getBranchById(@PathVariable Long id){
        Branch branch = branchRepo.findById(id).get();
        /*
        API call to external service
        20 Sec
         */
        Branch branch2 = branchRepo.findById(id).get();
        return ResponseEntity.ok(branch);
    }
}
