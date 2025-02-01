package com.example.L16_minor_project_01.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User user;
    private String name;
    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters and Setters
    // Constructor

//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Boolean getActive() {
//        return active;
//    }
//
//    public void setActive(Boolean active) {
//        this.active = active;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public LocalDateTime getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(LocalDateTime updatedAt) {
//        this.updatedAt = updatedAt;
//    }

//    public static class Builder {
//        private Long id;
//        private User user;
//        private String name;
//        private Boolean active;
//        private LocalDateTime createdAt;
//        private LocalDateTime updatedAt;
//
//        public Builder setId(Long id) {
//            this.id = id;
//            return this;
//        }
//
//        public Builder setUser(User user) {
//            this.user = user;
//            return this;
//        }
//
//        public Builder setName(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public Builder setActive(Boolean active) {
//            this.active = active;
//            return this;
//        }
//
//        public Builder setCreatedAt(LocalDateTime createdAt) {
//            this.createdAt = createdAt;
//            return this;
//        }
//
//        public Builder setUpdatedAt(LocalDateTime updatedAt) {
//            this.updatedAt = updatedAt;
//            return this;
//        }
//
//        public Company build() {
//            Company company = new Company();
//            company.setId(this.id);
//            company.setUser(this.user);
//            company.setName(this.name);
//            company.setActive(this.active);
//            company.setCreatedAt(this.createdAt);
//            company.setUpdatedAt(this.updatedAt);
//            return company;
//        }
//    }

}
