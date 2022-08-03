package com.example.tech.services;

import com.example.tech.models.Account;
import com.example.tech.models.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public interface TransactionService {
    ArrayList<Transaction> getAll();

    ArrayList<Transaction> getByAccount(Account account);

    ArrayList<Transaction> getByRange(Date from, Date until);

    ArrayList<Transaction> getByRangeAndAccount(Date from, Date until, Account account);

    Optional<Transaction> getById(Long id);

    Transaction save(Transaction transaction);

    Boolean deleteTransaction(Long id);
}
