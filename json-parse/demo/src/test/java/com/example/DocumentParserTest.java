package com.example;

import java.io.IOException;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.example.documents.Contract;
import com.example.documents.Document;
import com.example.exceptions.InvalidDocumentTypeException;
import com.example.exceptions.MissingFieldException;
import com.example.parser.DocumentParser;

class DocumentParserTest {

    

    @Test
    void testParseValidContract() throws IOException, MissingFieldException, InvalidDocumentTypeException {
        String filePath = "C:\\Users\\Jalal\\OneDrive\\Desktop\\java\\json-parse\\contract.json";
        Document document = DocumentParser.parse(filePath);

        assertNotNull(document);
        assertTrue(document instanceof Contract);
        Contract contract = (Contract) document;
        /*assertEquals("123", contract.getId());
        assertEquals(5000, contract.getCost());
        assertEquals("2024-11-19", contract.getDate());*/
        assertEquals("A1", contract.getId());
        assertEquals(5, contract.getCost());
        assertEquals("1-1-2023", contract.getDate());
    }

    @Test
    void testParseInvalidDocumentType() {
        String filePath = "C:\\Users\\Jalal\\OneDrive\\Desktop\\java\\json-parse\\invalidtype.json";

        assertThrows(InvalidDocumentTypeException.class, () -> DocumentParser.parse(filePath));
    }

    @Test
    void testParseMissingField() {
        String filePath = "C:\\Users\\Jalal\\OneDrive\\Desktop\\java\\json-parse\\missngfield.json";


        assertThrows(MissingFieldException.class, () -> DocumentParser.parse(filePath));
    }
}
