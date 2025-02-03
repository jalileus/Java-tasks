package com.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.example.documents.Contract;

class ContractClassTest {

    @Test
    void testConstructorAndGetters() {
        Contract contract = new Contract("123", 5000, "2024-11-19");
        assertEquals("123", contract.getId());
        assertEquals("CONTRACT", contract.getDocumentType());
        assertEquals(5000, contract.getCost());
        assertEquals("2024-11-19", contract.getDate());
    }

    @Test
    void testToString() {
        Contract contract = new Contract("123", 5000, "2024-11-19");
        String expected = "Contract{cost=5000, date='2024-11-19', id='123'}";
        assertEquals(expected, contract.toString());
    }
}
