package com.example.tech.controllers.request;

public class AccountDTO {
    private Long clientId;
    private Long number;
    private Short type;
    private Double balance;
    private Boolean status;

    public AccountDTO(Long clientId, Long number, Short type, Double balance, Boolean status) {
        this.clientId = clientId;
        this.number = number;
        this.balance = balance;
        this.type = type;
        this.status = status;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Boolean getStatus() {
        return status;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
