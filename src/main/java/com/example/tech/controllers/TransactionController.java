package com.example.tech.controllers;

import com.example.tech.controllers.request.TransactionDTO;
import com.example.tech.controllers.response.TransactionResponse;
import com.example.tech.models.Account;
import com.example.tech.models.Transaction;
import com.example.tech.services.Impl.GenerateTransaction;
import com.example.tech.services.AccountService;
import com.example.tech.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @Autowired
    GenerateTransaction generateTransaction;
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

    @GetMapping(path = "/range")
    public ArrayList<TransactionResponse> getByDateRange(
            @RequestParam(name = "from")
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
            @RequestParam(name = "until")
            @DateTimeFormat(pattern = "yyyy-MM-dd")Date until) {

        ArrayList<Transaction> transactionArrayList = transactionService.getByRange(from, until);
        ArrayList<TransactionResponse> transactionResponseArrayList = new ArrayList<TransactionResponse>();
        transactionArrayList.forEach(transaction -> {
            transactionResponseArrayList.add(new TransactionResponse(transaction));
        });
        return transactionResponseArrayList;
    }

    @GetMapping(path = "/range/{accountId}/account")
    public ArrayList<TransactionResponse> getByDateRangeAndClient(
            @PathVariable(name = "accountId") Long accountId,
            @RequestParam(name = "from")
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
            @RequestParam(name = "until")
            @DateTimeFormat(pattern = "yyyy-MM-dd")Date until) {
        Account account = accountService.getById(accountId).get();
        ArrayList<Transaction> transactionArrayList = transactionService.getByRangeAndAccount(from, until, account);
        ArrayList<TransactionResponse> transactionResponseArrayList = new ArrayList<TransactionResponse>();
        transactionArrayList.forEach(transaction -> {
            transactionResponseArrayList.add(new TransactionResponse(transaction));
        });
        return transactionResponseArrayList;
    }

    @PostMapping()
    public Transaction save(@RequestBody TransactionDTO transactionDTO) {
        Account account = accountService.getById(transactionDTO.getAccountId()).get();
        Transaction transaction = generateTransaction.create(transactionDTO, account);
        account.setBalance(transaction.getBalance());
        accountService.save(account);
        return transaction;
    }


    @PostMapping(path = "/generate")
    public TransactionResponse generate(@RequestBody TransactionDTO transactionDTO) {
        Account account = accountService.getByNumber(transactionDTO.getNumberAccount()).get();
        System.out.println(account);
        Transaction transaction = generateTransaction.create(transactionDTO, account);
        account.setBalance(transaction.getBalance());
        accountService.save(account);
        return new TransactionResponse(transaction);
    }

    @PatchMapping(path = "/{transactionId}")
    public ResponseEntity<HashMap<String, Object>> updateTransaction(
            @PathVariable("transactionId") Long transactionId,
            @RequestBody TransactionDTO transactionDTO) {

        HashMap<String, Object> response = new HashMap<>();
        HttpStatus httpStatus;
        try {
            Transaction transaction = transactionService.getById(transactionId).get();
            transaction.setClientDto(transactionDTO);
            transactionService.save(transaction);
            response.put("message", "account was updated successful");
            response.put("transactionId", transactionId);
            httpStatus = HttpStatus.OK;
        } catch (Exception err) {
            response.put("message", err.getMessage());
            httpStatus = HttpStatus.CONFLICT;
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @DeleteMapping(path = "/{transactionId}")
    public ResponseEntity<HashMap<String, Object>> delete(@PathVariable("transactionId") Long transactionId) {
        HashMap<String, Object> response = new HashMap<>();
        Transaction transaction = transactionService.getById(transactionId).get();
        HttpStatus httpStatus;
        if (transactionService.deleteTransaction(transactionId)) {
            Account account = transaction.getAccount();
            account.setBalance(transaction.getBalance() - transaction.getValue());
            accountService.save(account);
            response.put("message", "transaction was delete successful");
            httpStatus = HttpStatus.OK;
        } else {
            response.put("message", "transaction not delete account");
            httpStatus = HttpStatus.CONFLICT;
        }
        return new ResponseEntity<>(response, httpStatus);
    }
}
