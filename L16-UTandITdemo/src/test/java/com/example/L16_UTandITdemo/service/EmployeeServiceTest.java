package com.example.L16_UTandITdemo.service;

import com.example.L16_UTandITdemo.dto.EmployeeDetailReq;
import com.example.L16_UTandITdemo.entity.Address;
import com.example.L16_UTandITdemo.entity.Branch;
import com.example.L16_UTandITdemo.entity.Employee;
import com.example.L16_UTandITdemo.exception.IdCardNotAllocatedException;
import com.example.L16_UTandITdemo.exception.LaptopNotAllocatedException;
import com.example.L16_UTandITdemo.repo.EmployeeRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {

    private AutoCloseable autoCloseable;

    private EmployeeService employeeService;

    @Mock
    private EmployeeRepo employeeRepo;

    @Mock
    private BranchService branchService;

    private EmployeeDetailReq employeeDetailReq;

    private Employee employee;
    private Branch branch;

    @BeforeEach
    public void setup(){

        autoCloseable = MockitoAnnotations.openMocks(this);
        employeeService = new EmployeeService(employeeRepo,branchService);

        Address address = Address.builder()
                .id(1l)
                .line1("A-43")
                .line2("Sector-87")
                .city("Noida")
                .build();

        branch = Branch.builder()
                .id(1l)
                .name("Noida Branch")
                .build();

        employee = Employee.builder()
                .email("ravikumar@yopmail.com")
                .name("Ravi")
                .address(address)
                .branch(branch)
                .id(11l)
                .build();

        employeeDetailReq = EmployeeDetailReq.builder()
                .email("ravikumar@yopmail.com")
                .name("Ravi")
                .line1("A-43")
                .line2("Sector-87")
                .city("Noida")
                .branchId(1l)
                .build();

    }

    @Test
    public void  testCreateEmp() throws IdCardNotAllocatedException, LaptopNotAllocatedException {
        when(employeeRepo.save(any())).thenReturn(employee);
        when(branchService.get(1l)).thenReturn(branch);
        Employee createEmp = employeeService.createEmpWithTxn(employeeDetailReq);
//        assertThat(createEmp.getId()).isEqualTo(employee.getId());
        assertThat(createEmp).isEqualTo(employee);

    }

   // @Test
    public void  testCreateEmpWithInvalidAdhaar() throws IdCardNotAllocatedException, LaptopNotAllocatedException {
        when(employeeRepo.save(any())).thenReturn(employee);
        when(branchService.get(1l)).thenReturn(branch);

        assertThrows(IdCardNotAllocatedException.class,()-> employeeService.createEmpWithTxn(employeeDetailReq) );
//        assertThatExceptionOfType(employeeService.createEmpWithTxn(employeeDetailReq)).equals(IdCardNotAllocatedException.class);

    }


}
