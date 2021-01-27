package com.example.demo.exceptions;

public class DomainValidationException extends RuntimeException {
    public DomainValidationException() {
    }

    public DomainValidationException(String message) {
        super(message);
    }
}
