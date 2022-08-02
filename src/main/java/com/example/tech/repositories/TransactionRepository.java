package com.example.tech.repositories;

import com.example.tech.controllers.response.TransactionResponse;
import com.example.tech.models.Account;
import com.example.tech.models.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    public abstract ArrayList<Transaction> findByAccount(Account account);
    public abstract ArrayList<Transaction> findByDateTimeBetween(Date from, Date until);
    public abstract ArrayList<Transaction> findByDateTimeBetweenAndAccount(Date from, Date until, Account account);
}
