package com.aurionpro.model;

public class IDBI {

    private static final int MIN_BALANCE = 500;

    private String accountNumber;
    private String name;
    private int balance;
    private AccountType accountType;

    public IDBI(String name, int balance, AccountType accountType, String accountNumber) {
        this.name = name;
        this.balance = balance;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
    }

    public void viewBalance() {
        System.out.println("Your current balance is: " + balance);
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than 0.");
            return;
        }
        balance += amount;
        System.out.println(" " + amount + " deposited successfully.");
    }

    public boolean withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than 0.");
            return false;
        }
        if ((balance - amount) < MIN_BALANCE) {
            System.out.println("Cannot withdraw. Minimum balance of 500 must be maintained.");
            return false;
        }
        balance -= amount;
        System.out.println("You have withdrawn " + amount);
        return true;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    @Override
    public String toString() {
        return "IDBI Account Details:\n" +
               "Account Number: " + accountNumber + "\n" +
               "Name: " + name + "\n" +
               "Account Type: " + accountType + "\n" +
               "Current Balance: " + balance;
    }
}
