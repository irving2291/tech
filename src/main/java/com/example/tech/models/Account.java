package com.example.tech.models;

import com.example.tech.controllers.request.AccountDTO;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long accountId;

    @Column(unique = true, nullable = false)
    private Long number;

    private Short type;
    private Double balance;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "account")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Transaction> transactions;

    public Account(Long number, Short type, Double balance, Boolean status, Client client) {
        this.number = number;
        this.type = type;
        this.balance = balance;
        this.status = status;
        this.client = client;
    }

    public void setAccountDto(AccountDTO accountDTO) {
        if (accountDTO.getBalance() != null) {
            this.setBalance(accountDTO.getBalance());
        }
        if (accountDTO.getType() != null) {
            this.setType(accountDTO.getType());
        }
        if (accountDTO.getStatus() != null) {
            this.setStatus(accountDTO.getStatus());
        }
        if (accountDTO.getNumber() != null) {
            this.setNumber(accountDTO.getNumber());
        }
    }

    public Account() {
        //
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
