package com.aurionpro.payment;

public interface IPaymentStrategy {
	String getPaymentMode();

	void pay(double amount);
}
