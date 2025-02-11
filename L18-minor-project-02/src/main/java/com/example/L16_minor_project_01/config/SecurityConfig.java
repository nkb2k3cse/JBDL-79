package com.example.L16_minor_project_01.config;

import com.example.L16_minor_project_01.entity.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .authorizeHttpRequests(auth ->{
                    auth.requestMatchers("/api/admin/**").hasAnyAuthority(Role.ADMIN.name())
                            .requestMatchers("/api/customer/**").hasAnyAuthority(Role.CUSTOMER.name())
                            .requestMatchers("/api/seller/**").hasAnyAuthority(Role.SELLER.name())
                            .requestMatchers("/public/**")
                            .permitAll()
                            .anyRequest()
                            .authenticated();
                })
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }


}
