package com.example.tech.controllers.request;

import java.util.Date;

public class TransactionDTO {
    private Long accountId;
    private Short type;
    private Double value;
    private Double balance;

    public TransactionDTO(Long accountId, Short type, Double value, Double balance) {
        this.accountId = accountId;
        this.type = type;
        this.value = value;
        this.balance = balance;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
