package com.example.tech.services.Impl;

import com.example.tech.models.Account;
import com.example.tech.models.Transaction;
import com.example.tech.repositories.TransactionRepository;
import com.example.tech.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
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

    public Optional<Transaction> getById(Long id) {
        return transactionRepository.findById(id);
    }

    public Boolean deleteTransaction(Long id) {
        try {
            transactionRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
