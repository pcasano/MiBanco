package org.example.model;

import java.util.UUID;

public class Transaction {

    private String id;
    private Integer amount;
    private String timestamp;
    private String reference;

    public Transaction(Integer amount, String timestamp, String reference) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.timestamp = timestamp;
        this.reference = reference;
    }

    public String getId() {
        return id;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getReference() {
        return reference;
    }
}
