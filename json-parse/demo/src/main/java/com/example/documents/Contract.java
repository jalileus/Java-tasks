package com.example.documents;


public class Contract extends Document {
    private final int cost;
    private final String date;

    public Contract(String id, int cost, String date) {
        super(id, "CONTRACT");
        this.cost = cost;
        this.date = date;
    }

    public int getCost() {
        return cost;
    }

    public String getDate() {
        return date;
    }

        @Override
    public String toString() {
        return "Contract{" +
               "cost=" + cost +
               ", date='" + date + '\'' +
               ", id='" + getId() + '\'' +
               '}';
    }
}