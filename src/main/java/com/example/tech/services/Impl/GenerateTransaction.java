package com.example.tech.services.Impl;

import com.example.tech.controllers.request.TransactionDTO;
import com.example.tech.models.Account;
import com.example.tech.models.Transaction;

public interface GenerateTransaction {
    Transaction create(TransactionDTO transactionDTO, Account account);
}
