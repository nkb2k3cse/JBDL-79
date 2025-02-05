package com.example.L16_UTandITdemo.repo;

import com.example.L16_UTandITdemo.dto.EmployeeDetailReq;
import com.example.L16_UTandITdemo.entity.Address;
import com.example.L16_UTandITdemo.entity.Branch;
import com.example.L16_UTandITdemo.entity.Employee;
import com.example.L16_UTandITdemo.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest(
        properties = {
                "spring.datasource.url=jdbc:h2:mem:testdb",
                "spring.jpa.hibernate.ddl-auto=create-drop"
        }
)
public class EmployeeRepoTest {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private BranchRepo branchRepo;



    private Employee employee;
    private Branch branch;

    @BeforeEach
    public void setup(){
        Address address = Address.builder()
                .line1("A-43")
                .line2("Sector-87")
                .city("Noida")
                .build();

        branch = Branch.builder()
                .name("Noida Branch")
                .build();
        branch = branchRepo.save(branch);

        employee = Employee.builder()
                .email("ravikumar@yopmail.com")
                .name("Ravi")
                .address(address)
                .branch(branch)
                .build();
        employee = employeeRepo.save(employee);
    }


    @Test
    public void testFindByEmail(){
        Employee employeeReturned = employeeRepo.findByEmail("ravikumar@yopmail.com");
        assertThat(employeeReturned).isEqualTo(employee);
    }




}
