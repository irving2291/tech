package com.example.tech.repositories;

import com.example.tech.models.Account;
import com.example.tech.models.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    public abstract ArrayList<Transaction> findByAccount(Account account);
}
