package com.bank.model;

public class Account {
    private long accountNo;
    private int userId;
    private double balance;
    private String pin;

    public long getAccountNo() { return accountNo; }
    public void setAccountNo(long accountNo) { this.accountNo = accountNo; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public String getPin() { return pin; }
    public void setPin(String pin) { this.pin = pin; }
}
