package com.aurionpro.payment;

public class CashPayment implements IPaymentStrategy {
    @Override
    public String getPaymentMode() {
        return "Cash";
    }

    @Override
    public void pay(double amount) {
        System.out.println("Payment of ₹" + amount + " done via Cash.");
    }
}
