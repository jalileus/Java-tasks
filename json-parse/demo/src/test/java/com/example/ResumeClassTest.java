package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.example.documents.Resume;

class ResumeClassTest {

    @Test
    void testConstructorAndGetters() {
        Resume resume = new Resume("789", "John Doe");
        assertEquals("789", resume.getId());
        assertEquals("RESUME", resume.getDocumentType());
        assertEquals("John Doe", resume.getName());
    }

    @Test
    void testToString() {
        Resume resume = new Resume("789", "John Doe");
        String expected = "Resume{name='John Doe', id='789'}";
        assertEquals(expected, resume.toString());
    }
}
