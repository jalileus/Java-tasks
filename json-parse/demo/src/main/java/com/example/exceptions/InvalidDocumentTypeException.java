package com.example.exceptions;

public class InvalidDocumentTypeException extends Exception {
    public InvalidDocumentTypeException(String message) {
        super(message);
    }

    public InvalidDocumentTypeException() {
        super("Invalid document type encountered.");
    }
}