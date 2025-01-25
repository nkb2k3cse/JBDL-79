package com.example.L15_minor_project_01.repo;

import com.example.L15_minor_project_01.entity.Company;
import com.example.L15_minor_project_01.entity.Order;
import com.example.L15_minor_project_01.entity.OrderStatus;
import com.example.L15_minor_project_01.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {
    List<Order> findByStatusAndUser(OrderStatus status, User user);

   // List<Order> findByStatusAndCompany(OrderStatus status, Company company);
}
