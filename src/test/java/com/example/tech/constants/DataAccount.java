package com.example.tech.constants;

import com.example.tech.models.Account;
import com.example.tech.models.Client;

import java.util.Optional;

public class DataAccount {
    public static Optional<Account> createAccount001() {
        Client client = DataClient.createClient001().get();
        Account account = new Account(123L, (short) 1, 100.0, true, client);
        account.setAccountId(1L);
        return Optional.of(account);
    }
}
