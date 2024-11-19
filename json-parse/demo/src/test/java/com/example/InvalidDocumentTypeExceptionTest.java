package com.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.example.exceptions.InvalidDocumentTypeException;

class InvalidDocumentTypeExceptionTest {

    @Test
    void testMessageConstructor() {
        String message = "Custom error message";
        InvalidDocumentTypeException exception = new InvalidDocumentTypeException(message);
        assertEquals(message, exception.getMessage());
    }

    @Test
    void testDefaultConstructor() {
        InvalidDocumentTypeException exception = new InvalidDocumentTypeException();
        assertEquals("Invalid document type encountered.", exception.getMessage());
    }
}
