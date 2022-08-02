package com.example.tech.services;

import com.example.tech.controllers.request.TransactionDTO;
import com.example.tech.controllers.response.TransactionResponse;
import com.example.tech.models.Account;
import com.example.tech.models.Client;
import com.example.tech.models.Transaction;
import com.example.tech.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    public ArrayList<Transaction> getAll() {
        return (ArrayList<Transaction>) transactionRepository.findAll();
    }

    public ArrayList<Transaction> getByAccount(Account account) {
        return (ArrayList<Transaction>) transactionRepository.findByAccount(account);
    }

    public ArrayList<Transaction> getByRange(Date from, Date until) {
        return (ArrayList<Transaction>) transactionRepository.findByDateTimeBetween(from, until);
    }

    public ArrayList<Transaction> getByRangeAndAccount(Date from, Date until, Account account) {
        return (ArrayList<Transaction>) transactionRepository.findByDateTimeBetweenAndAccount(from, until, account);
    }
}
