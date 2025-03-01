package com.example.L22_circuit_breaker_demo;

public class ProductDto {
    private Long id;

    private String name;

    private Double cost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public ProductDto(Long id, String name, Double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }
}

