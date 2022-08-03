package com.example.tech.models;

import com.example.tech.controllers.request.ClientTDO;
import com.example.tech.controllers.request.TransactionDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long transactionId;

    private Date dateTime;
    private Short type;
    private Double value;
    private Double balance;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Account getAccount() {
        return account;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
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

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setClientDto(TransactionDTO transactionDTO) {
        if (transactionDTO.getValue() != null) {
            this.setValue(transactionDTO.getValue());
        }
        if (transactionDTO.getType() != null) {
            this.setType(transactionDTO.getType());
        }
        if (transactionDTO.getBalance() != null) {
            this.setBalance(transactionDTO.getBalance());
        }
    }
}
