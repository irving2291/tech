package com.example.tech.controllers;

import com.example.tech.controllers.request.AccountDTO;
import com.example.tech.controllers.request.TransactionDTO;
import com.example.tech.models.Account;
import com.example.tech.models.Client;
import com.example.tech.models.Transaction;
import com.example.tech.services.AccountService;
import com.example.tech.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @Autowired
    AccountService accountService;

    @GetMapping()
    public ArrayList<Transaction> getAll() {
        return transactionService.getAll();
    }

    @GetMapping(path = "/{accountId}")
    public ArrayList<Transaction> getByAccount(@PathVariable("accountId") long accountId) {
        Account account = accountService.getById(accountId).get();
        return transactionService.getByAccount(account);
    }

    @PostMapping()
    public Transaction save(@RequestBody TransactionDTO transactionDTO) {
        Account account = accountService.getById(transactionDTO.getAccountId()).get();
        return transactionService.create(transactionDTO, account);
    }
}
