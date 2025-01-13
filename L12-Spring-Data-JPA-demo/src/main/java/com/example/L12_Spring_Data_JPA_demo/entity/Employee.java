package com.example.L12_Spring_Data_JPA_demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "empName", nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToOne
    private Address address;

    @ManyToOne
    private Branch branch;

}

