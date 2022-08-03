package com.example.tech.services.Impl;

import com.example.tech.controllers.request.TransactionDTO;
import com.example.tech.exceptions.UnavailableBalance;
import com.example.tech.models.Account;
import com.example.tech.models.Transaction;
import com.example.tech.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GenerateTransactionImpl implements GenerateTransaction {
    @Autowired
    TransactionRepository transactionRepository;

    public Transaction create(TransactionDTO transactionDTO, Account account) {
        Transaction transaction = new Transaction();
        double newBalance = account.getBalance() + transactionDTO.getValue();
        if (newBalance >= 0) {

            transaction.setAccount(account);
            transaction.setDateTime(new Date(System.currentTimeMillis()));
            transaction.setType(transactionDTO.getType());
            transaction.setValue(transactionDTO.getValue());
            transaction.setBalance(newBalance);
            return transactionRepository.save(transaction);
        } else {
            throw new UnavailableBalance("the value to withdraw not available");
        }
    }
}
