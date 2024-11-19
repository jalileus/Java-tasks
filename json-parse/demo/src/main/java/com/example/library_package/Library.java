package com.example.library_package;
import java.util.HashMap;
import java.util.Map;

import com.example.documents.Document;


public class Library<T extends Document> {
    private final Map<String, T> documents = new HashMap<>();

    public void add(T document)    {
    if (documents.containsKey(document.getId())) {
        throw new IllegalArgumentException ("Document with ID already exists: " + document.getId());
    }
    documents.put(document.getId(), document);
}


    public T get(String id)   {
        if(!documents.containsKey(id))  {
            throw new IllegalArgumentException ("No document found with ID: " + id);
        }
        return documents.get(id);
    }

    public void remove(String id)  {
        if (!documents.containsKey(id)) {
            throw new IllegalArgumentException ("Document with ID not found: " + id);
        }
        documents.remove(id);
    }
}
