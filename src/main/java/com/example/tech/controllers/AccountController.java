package com.example.tech.controllers;

import com.example.tech.controllers.request.AccountDTO;
import com.example.tech.models.Account;
import com.example.tech.models.Client;
import com.example.tech.services.AccountService;
import com.example.tech.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;
    @Autowired
    ClientService clientService;

    @GetMapping()
    public ArrayList<Account> getAll() {
        return accountService.getAll();
    }

    @PostMapping()
    public Account save(@RequestBody AccountDTO accountDTO) {
        Client client = clientService.getById(accountDTO.getClientId()).get();
        return accountService.create(accountDTO, client);
    }

    @GetMapping(path = "/{number}/number")
    public Account getByNumberAccount(@PathVariable("number") Long number) {
        return accountService.getByNumber(number).get();
    }

    @PatchMapping(path = "/{accountId}")
    public ResponseEntity<HashMap<String, Object>> updateAccount(
            @PathVariable("accountId") Long accountId,
            @RequestBody AccountDTO accountDTO) {

        HashMap<String, Object> response = new HashMap<>();
        HttpStatus httpStatus;
        try {
            Account account = accountService.getById(accountId).get();
            account.setAccountDto(accountDTO);
            accountService.save(account);
            response.put("message", "account was updated successful");
            response.put("accountId", accountId);
            httpStatus = HttpStatus.OK;
        } catch (Exception err) {
            response.put("message", err.getMessage());
            httpStatus = HttpStatus.CONFLICT;
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @DeleteMapping(path = "/{accountId}")
    public ResponseEntity<HashMap<String, Object>> delete(@PathVariable("accountId") Long accountId) {
        HashMap<String, Object> response = new HashMap<>();
        HttpStatus httpStatus;
        if (accountService.deleteAccount(accountId)) {
            response.put("message", "account was delete successful");
            httpStatus = HttpStatus.OK;
        } else {
            response.put("message", "could not delete account");
            httpStatus = HttpStatus.CONFLICT;
        }
        return new ResponseEntity<>(response, httpStatus);
    }
}
