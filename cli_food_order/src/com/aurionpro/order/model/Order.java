package com.aurionpro.order.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private List<OrderItem> orderItems;
	private double totalAmount;
	private double discount;
	private String paymentMode;
	private String deliveryPartner;

	public Order(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	public Order() {
		this.orderItems = new ArrayList<>();
	}
	
	public void addItem(OrderItem item) {
		this.orderItems.add(item);
	}
	
	public double calculateTotalAmount() {
		double sum = 0;
		for (OrderItem item : orderItems) {
			sum += item.getSubtotal();
		}
		this.totalAmount = sum - discount;
		return this.totalAmount;
	}


	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public void setDeliveryPartner(String deliveryPartner) {
		this.deliveryPartner = deliveryPartner;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public double getDiscount() {
		return discount;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public String getDeliveryPartner() {
		return deliveryPartner;
	}
}
