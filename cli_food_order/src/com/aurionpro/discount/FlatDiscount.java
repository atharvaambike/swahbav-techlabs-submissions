package com.aurionpro.discount;

public class FlatDiscount implements IDiscountStrategy {

	private final DiscountConfig config;

	public FlatDiscount(DiscountConfig config) {
		this.config = config;
	}

	@Override
	public double calculateDiscount(double totalAmount) {
		return totalAmount >= config.getThreshold() ? config.getDiscountAmount() : 0;
	}
}
