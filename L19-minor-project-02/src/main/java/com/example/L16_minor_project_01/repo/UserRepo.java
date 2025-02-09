package com.example.L16_minor_project_01.repo;

import com.example.L16_minor_project_01.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    public User findByEmail(String email);
}
