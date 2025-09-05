package com.bank.model;

import java.util.Date;

public class Transaction {
    private Date createdAt;
    private String type;
    private double amount;
    private String description;
    private Long counterpartyAccount;

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Long getCounterpartyAccount() { return counterpartyAccount; }
    public void setCounterpartyAccount(Long counterpartyAccount) { this.counterpartyAccount = counterpartyAccount; }
}
