package com.example.L13_Spring_Data_JPA_demo.service;

import com.example.L13_Spring_Data_JPA_demo.dao.BranchRepo;
import com.example.L13_Spring_Data_JPA_demo.dao.EmpRepo;
import com.example.L13_Spring_Data_JPA_demo.dto.EmployeeDetailReq;
import com.example.L13_Spring_Data_JPA_demo.entity.Address;
import com.example.L13_Spring_Data_JPA_demo.entity.Branch;
import com.example.L13_Spring_Data_JPA_demo.entity.Employee;
import com.example.L13_Spring_Data_JPA_demo.exceptions.AdhaarNotVerifiedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class EmpService {

    private static Logger LOGGER = LoggerFactory.getLogger(EmpService.class);

    @Autowired
    private EmpRepo empRepo;

    @Autowired
    private BranchRepo branchRepo;

    public List<Employee> getAll(){
        return empRepo.findAll();
    }

    @Transactional
    public Employee findByEmail(String email){
        Employee employee = empRepo.findByEmail(email);

        return employee;
    }

    @Transactional(rollbackFor = AdhaarNotVerifiedException.class)
    public Long createEmp(EmployeeDetailReq detailReq) throws AdhaarNotVerifiedException {

        boolean isLaptopAllocated = true;
        boolean isAadhaarVerified = false;

        Branch branch = branchRepo.findById(detailReq.getBranchId()).get();

        Employee employee = new Employee();
        employee.setName(detailReq.getName());
        employee.setEmail(detailReq.getEmail());
        Address address = new Address();
        address.setCity(detailReq.getCity());
        address.setLine1(detailReq.getLine1());
        address.setLine2(detailReq.getLine2());
        employee.setAddress(address);
        employee.setBranch(branch);
        employee = empRepo.save(employee);
        if(!isAadhaarVerified){
            // CAll API of Aadhaar
            throw new AdhaarNotVerifiedException("AdhaarNotVerifiedException");
        }
        return employee.getId();
    }

    /*
    Allocate Laptop
    Verify Aadhaar
     */

    /*

    Fetch from DB by Id
    DB Update address1 --> PC --> DB
    DB Update address2 --> PC --> DB
    Fetch from DB by Id // updated data

     */
}
