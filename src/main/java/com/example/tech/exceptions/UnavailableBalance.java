package com.example.tech.exceptions;

public class UnavailableBalance extends RuntimeException {

    public UnavailableBalance(String errorMessage) {
        super(errorMessage);
    }
}
