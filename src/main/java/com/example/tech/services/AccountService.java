package com.example.tech.services;

import com.example.tech.controllers.request.AccountDTO;
import com.example.tech.models.Account;
import com.example.tech.models.Client;

import java.util.ArrayList;
import java.util.Optional;

public interface AccountService {
    ArrayList<Account> getAll();
    Optional<Account> getById(Long id);
    Optional<Account> getByNumber(Long number);
    Account create(AccountDTO accountDTO, Client client);
    Account save(Account account);
    Boolean deleteAccount(Long id);
}
