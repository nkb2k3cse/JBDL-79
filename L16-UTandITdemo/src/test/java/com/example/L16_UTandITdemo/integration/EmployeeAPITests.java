package com.example.L16_UTandITdemo.integration;

import com.example.L16_UTandITdemo.dto.EmployeeDetailReq;
import com.example.L16_UTandITdemo.entity.Address;
import com.example.L16_UTandITdemo.entity.Branch;
import com.example.L16_UTandITdemo.entity.Employee;
import com.example.L16_UTandITdemo.repo.BranchRepo;
import com.example.L16_UTandITdemo.repo.EmployeeRepo;
import com.example.L16_UTandITdemo.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(
        locations = ("classpath:application-it.properties")
)
public class EmployeeAPITests {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BranchRepo branchRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    private EmployeeDetailReq employeeDetailReq;


    private Branch branch;


    @BeforeEach
    public void setup(){

        branch = Branch.builder()
                .name("Noida Branch")
                .build();

        branch = branchRepo.save(branch);

        employeeDetailReq = EmployeeDetailReq.builder()
                .email("ravikumar@yopmail.com")
                .name("Ravi")
                .line1("A-43")
                .line2("Sector-87")
                .city("Noida")
                .branchId(branch.getId())
                .build();

    }

    @Test
    public void testCreateEmpAPI() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonData = objectMapper.writeValueAsString(employeeDetailReq);

        mockMvc.perform(post("/emp")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonData))
                .andDo(print()).andExpect(status().isOk());

        Employee employeeFromDB = employeeRepo.findByEmail("ravikumar@yopmail.com");
        assertThat(employeeFromDB).isNotNull();

    }
}
