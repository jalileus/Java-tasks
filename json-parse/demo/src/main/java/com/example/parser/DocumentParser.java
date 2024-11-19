package com.example.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.example.documents.Contract;
import com.example.documents.Document;
import com.example.documents.Receipt;
import com.example.documents.Resume;
import com.example.exceptions.InvalidDocumentTypeException;
import com.example.exceptions.MissingFieldException;

public class DocumentParser {

    public static Document parse(String filePath) throws IOException, MissingFieldException, InvalidDocumentTypeException {
        String json = Files.readString(Paths.get(filePath)).trim()
                           .replace("{", "").replace("}", "").replace("\"", "");
        String id = null, documentType = null, stringField = null;
        Integer intField = null;

        String[] fields = json.split(",");
        for (String field : fields) {
            String[] keyValue = field.trim().split(":");
            if (keyValue.length != 2) {
                throw new MissingFieldException("Invalid field format: " + field);
            }
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();

            switch (key) {
                case "id" -> id = value;
                case "document_type" -> documentType = value;
                case "cost", "money_amount" -> intField = Integer.valueOf(value);
                case "date", "name" -> stringField = value;
                default -> throw new MissingFieldException("Unexpected field: " + key);
            }
        }

        if (id == null || documentType == null) {
            throw new MissingFieldException("Missing required fields: id or document_type");
        }

        return switch (documentType) {
            case "CONTRACT" -> new Contract(id, intField, stringField);
            case "RECEIPT" -> new Receipt(id, intField);
            case "RESUME" -> new Resume(id, stringField);
            default -> throw new InvalidDocumentTypeException("Unsupported document_type: " + documentType);
        };
    }
}
