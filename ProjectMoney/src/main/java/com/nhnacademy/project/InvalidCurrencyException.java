package com.nhnacademy.project;

import org.springframework.beans.factory.annotation.Autowired;

public class InvalidCurrencyException extends RuntimeException {

    public InvalidCurrencyException(String message) {
        super(message);
    }
}
