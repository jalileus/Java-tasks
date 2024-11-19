package com.example.documents;
public abstract class Document {
    private final  String id;
    private final  String documentType;

    public Document(String id, String documentType) {
        this.id = id;
        this.documentType = documentType;
    }

    public String getId() {
        return id;
    }

    public String getDocumentType() {
        return documentType;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", documentType='" + documentType + '\'' +
                '}';
    }
    
}