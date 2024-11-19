package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.example.documents.Contract;
import com.example.documents.Document;
import com.example.library_package.Library;

class LibraryClassTest {

    @Test
    void testAddAndGetDocument()  {
        Library<Document> library = new Library<>();
        
        Document contract = new Contract("123", 5000, "2024-11-19");
        
        library.add(contract);
        Document retrieved = library.get("123");

        assertNotNull(retrieved);
        assertEquals("123", retrieved.getId());
        assertEquals("CONTRACT", retrieved.getDocumentType());
    }

    @Test
    void testAddDuplicateDocumentThrowsException() {
    
        Library<Document> library = new Library<>();
        
    
        Document contract1 = new Contract("123", 5000, "2024-11-19");
        library.add(contract1);

        Document contract2 = new Contract("123", 1000, "2024-11-20");

        assertThrows(IllegalArgumentException.class, () -> library.add(contract2));

    }

    @Test
    void testGetDocumentNotFound()  {
    
        Library<Document> library = new Library<>();
        
        Document contract = new Contract("123", 5000, "2024-11-19");
        library.add(contract);
        
        assertThrows(IllegalArgumentException.class, () -> library.get("999"));
    }

    @Test
    void testRemoveDocument() {

        Library<Document> library = new Library<>();
        

        Document contract = new Contract("123", 5000, "2024-11-19");
        library.add(contract);

    
        library.remove("123");

        assertThrows(IllegalArgumentException.class, () -> library.get("123"));
    }
}
