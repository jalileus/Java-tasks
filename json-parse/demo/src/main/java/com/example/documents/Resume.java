package com.example.documents;
public class  Resume extends Document {
    private final String name;

    public Resume(String id, String name){
        super(id, "RESUME");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Resume{" +
               "name='" + name + '\'' +
               ", id='" + getId() + '\'' +
               '}';
    }
}