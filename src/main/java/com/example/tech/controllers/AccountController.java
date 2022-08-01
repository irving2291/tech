package com.example.tech.controllers;

import com.example.tech.controllers.request.AccountDTO;
import com.example.tech.models.Account;
import com.example.tech.models.Client;
import com.example.tech.services.AccountService;
import com.example.tech.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;
    @Autowired
    ClientService clientService;

    @PostMapping()
    public Account save(@RequestBody AccountDTO accountDTO) {
        Client client = clientService.getById(accountDTO.getClientId()).get();
        Logger logger = LoggerFactory.getLogger(client.getName());
        logger.info("es este: " + client.getName());
        return accountService.create(accountDTO, client);
    }
}
