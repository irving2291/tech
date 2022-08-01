package com.example.tech.services;

import com.example.tech.controllers.AccountController;
import com.example.tech.controllers.request.AccountDTO;
import com.example.tech.models.Account;
import com.example.tech.models.Client;
import com.example.tech.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public Account create(AccountDTO accountDTO, Client client) {
        Account account = new Account(accountDTO.getNumber(), accountDTO.getType(), accountDTO.getStatus(), client);
        return accountRepository.save(account);
    }
}