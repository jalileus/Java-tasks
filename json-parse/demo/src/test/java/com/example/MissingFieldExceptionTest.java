package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.example.exceptions.MissingFieldException;

class MissingFieldExceptionTest {

    @Test
    void testMessageConstructor() {
        String message = "Missing field in the document";
        MissingFieldException exception = new MissingFieldException(message);
        assertEquals(message, exception.getMessage());
    }

    @Test
    void testDefaultConstructor() {
        MissingFieldException exception = new MissingFieldException();
        assertEquals("A required field is missing.", exception.getMessage());
    }
}
