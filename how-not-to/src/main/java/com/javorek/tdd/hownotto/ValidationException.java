package com.javorek.tdd.hownotto;

import lombok.RequiredArgsConstructor;

public class ValidationException extends RuntimeException{
    public ValidationException(String message) {
        super(message);
    }
}
