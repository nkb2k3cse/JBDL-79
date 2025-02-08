package com.example.L18_SpringSecurity_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

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


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                //.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .authorizeHttpRequests((auth) ->{
                    auth.requestMatchers("/admin/**").hasAnyAuthority("ADMIN")
                            .requestMatchers("/public/**")
                            .permitAll().anyRequest().authenticated();
                })
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }


    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("rahul123"));
    }
}
/*
$2a$10$c/D2BhfVyTE2EI/b4Y2waucGgJ.usnyfb44lAJbKCtISIsIMTqC2y
$2a$10$SUfwsU6m0y66t0HRUPo4wu0nAy6K39xxpdeAWzWlW7Z/4qLXvJEfi
DB User
email:
password: $2a$10$ikvyL.BE2wK6s7hYvKfGW.h85Y1wfEXF7WlmHSCmigcuzAxc6MUxO
$2a$10$3iBhKpr/SujKgQO2FlbIqeYoCCEh0kF2yT88fgZ1NqTHAG/9tMGsW
 */
