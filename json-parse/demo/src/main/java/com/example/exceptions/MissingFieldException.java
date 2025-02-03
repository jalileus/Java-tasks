package com.example.exceptions;

public class MissingFieldException extends Exception {
    public MissingFieldException(String message) {
        super(message);
    }

        public MissingFieldException() {
        super("A required field is missing.");
    }
    
}

