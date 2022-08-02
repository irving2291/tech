package com.example.tech.repositories;

import com.example.tech.models.Account;
import com.example.tech.models.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    public abstract Optional<Account> findByNumber(Long number);
}
