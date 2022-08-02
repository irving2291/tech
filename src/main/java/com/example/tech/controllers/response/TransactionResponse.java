package com.example.tech.controllers.response;

import com.example.tech.enums.AccountType;
import com.example.tech.enums.EnumTypes;
import com.example.tech.models.Client;
import com.example.tech.models.Transaction;

import java.util.Date;

public class TransactionResponse {

    private Date dateTime;
    private String clientName;
    private String type;
    private Double initial;
    private Double value;
    private Double balance;
    private Boolean status;


    public TransactionResponse(Transaction transaction) {
        Client client = transaction.getAccount().getClient();
        this.clientName = client.getName() + " " + client.getLastName();
        this.dateTime = transaction.getDateTime();
        if (EnumTypes.accountTypeTo(transaction.getType()) == AccountType.CURRENT) {
            this.type = "Current";
        } else {
            this.type = "Savings";
        }
        this.value = transaction.getValue();
        this.balance = transaction.getBalance();
        this.initial = transaction.getBalance() - transaction.getValue();
    }

    public String getClientName() {
        return clientName;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public String getType() {
        return type;
    }

    public Double getValue() {
        return value;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getInitial() {
        return initial;
    }
}
