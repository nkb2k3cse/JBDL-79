package com.example.L17_SpringSecurity_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
//
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user1 = User.builder()
//                .username("rahul").password("$2a$10$3iBhKpr/SujKgQO2FlbIqeYoCCEh0kF2yT88fgZ1NqTHAG/9tMGsW")
//                .roles("USER").build();
//
//        UserDetails user2 = User.builder()
//                .username("ravi").password("$2a$10$ikvyL.BE2wK6s7hYvKfGW.h85Y1wfEXF7WlmHSCmigcuzAxc6MUxO")
//                .roles("USER").build();
//
//        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
//        inMemoryUserDetailsManager.createUser(user1);
//        inMemoryUserDetailsManager.createUser(user2);
//
//        return inMemoryUserDetailsManager;
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        //return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }

//    public static void main(String[] args) {
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        System.out.println(passwordEncoder.encode("rahul123"));
//    }
}
/*
DB User
email:
password: $2a$10$ikvyL.BE2wK6s7hYvKfGW.h85Y1wfEXF7WlmHSCmigcuzAxc6MUxO
$2a$10$3iBhKpr/SujKgQO2FlbIqeYoCCEh0kF2yT88fgZ1NqTHAG/9tMGsW
 */
