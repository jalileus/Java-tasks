package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.example.documents.Receipt;

class ReceiptClassTest {

    @Test
    void testConstructorAndGetters() {
        Receipt receipt = new Receipt("456", 1000);
        assertEquals("456", receipt.getId());
        assertEquals("RECEIPT", receipt.getDocumentType());
        assertEquals(1000, receipt.getMoneyAmount());
    }

    @Test
    void testToString() {
        Receipt receipt = new Receipt("456", 1000);
        String expected = "Receipt{moneyAmount=1000, id='456'}";
        assertEquals(expected, receipt.toString());
    }
}
