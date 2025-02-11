package com.example.L19_OAuth_demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepo extends JpaRepository<MyUser,Long> {

    MyUser findByEmail(String email);
}
