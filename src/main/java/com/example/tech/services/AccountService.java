package com.example.tech.services;

import com.example.tech.controllers.AccountController;
import com.example.tech.controllers.request.AccountDTO;
import com.example.tech.models.Account;
import com.example.tech.models.Client;
import com.example.tech.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public ArrayList<Account> getAll() {
        return (ArrayList<Account>) accountRepository.findAll();
    }

    public Optional<Account> getById(Long id) {
        return accountRepository.findById(id);
    }

    public Optional<Account> getByNumber(Long number) {
        return accountRepository.findByNumber(number);
    }

    public Account create(AccountDTO accountDTO, Client client) {
        Account account = new Account(accountDTO.getNumber(), accountDTO.getType(), accountDTO.getBalance(), accountDTO.getStatus(), client);
        if (account.getNumber() == null) {
            account.setNumber(new Random().nextLong(1999999999));
        }
        return accountRepository.save(account);
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public Boolean deleteAccount(Long id) {
        try {
            accountRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
