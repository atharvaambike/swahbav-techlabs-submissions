package com.aurionpro.payment;

public class UPIPayment implements IPaymentStrategy {

    @Override
    public String getPaymentMode() {
        return "UPI";
    }

    @Override
    public void pay(double amount) {
        System.out.println("Payment of ₹" + amount + " done via UPI.");
    }
}
