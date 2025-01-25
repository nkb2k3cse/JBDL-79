package com.example.L15_minor_project_01.dto;

public class CreateProductResponseDto {
    private Long productId;
    private String msg;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
