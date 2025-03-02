package com.example.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddMoneyRequest {
    private Double amount;
    private Long userId;

    //for internal use
    private Long merchantId;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
