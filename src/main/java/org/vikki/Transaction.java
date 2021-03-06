package org.vikki;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private String id;
    private Integer amount;
    private LocalDateTime timestamp;
    private String reference;

    public Transaction() {
    }

    public Transaction(Integer amount, String reference) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.timestamp =  LocalDateTime.now();
        this.reference = reference;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
