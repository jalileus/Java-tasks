package com.example.documents;

public class Receipt extends Document {
    private final int moneyAmount;

    public Receipt(String id, int moneyAmount) {
        super(id, "RECEIPT");
        this.moneyAmount = moneyAmount;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

        @Override
    public String toString() {
        return "Receipt{" +
               "moneyAmount=" + moneyAmount +
               ", id='" + getId() + '\'' +
               '}';
    }
}