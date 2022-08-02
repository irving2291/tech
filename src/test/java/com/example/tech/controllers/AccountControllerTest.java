package com.example.tech.controllers;

import com.example.tech.controllers.request.AccountDTO;
import com.example.tech.models.Account;
import com.example.tech.repositories.AccountRepository;
import com.example.tech.services.AccountService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class AccountControllerTest {

    @InjectMocks
    AccountController accountController;
    @Mock
    AccountService accountService;

    void setUp() throws Exception
    {
        MockitoAnnotations.openMocks(this);
        AccountDTO accountDTO = new AccountDTO(1L, 1234L, (short) 1, 1000.0, true);
    }

    @Test
    void getAll() {
    }

    @Test
    void save() {
    }

    @Test
    void getByNumberAccount() {
        Long number = 1232L;
        accountService.getByNumber(number).get();
        Account account = accountController.getByNumberAccount(number);
        assertNotNull(account);
    }

    @Test
    void updateAccount() {
    }

    @Test
    void delete() {
    }
}