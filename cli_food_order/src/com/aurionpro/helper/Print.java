package com.aurionpro.helper;

import java.util.List;
import com.aurionpro.food.model.Food;
import com.aurionpro.order.model.Order;
import com.aurionpro.order.model.OrderItem;

public class Print {

	public static void displayFoodMenu(List<Food> foodItems) {
		for (Food food : foodItems) {
			System.out.println(food.getId() + " - " + food.getName() + " ₹" + food.getPrice());
		}
	}

	public static void printInvoice(Order order) {
		System.out.println("\n========== INVOICE ==========");
		System.out.printf("%-30s %-10s %-10s %-10s\n", "Item", "Qty", "Price", "Subtotal");
		System.out.println("------------------------------------------------------------");

		for (OrderItem item : order.getOrderItems()) {
			String name = item.getFood().getName();
			int qty = item.getQuantity();
			double price = item.getFood().getPrice();
			double subtotal = item.getSubtotal();
			System.out.printf("%-30s %-10d %-10.2f %-10.2f\n", name, qty, price, subtotal);
		}

		System.out.println("------------------------------------------------------------");
		double total = order.calculateTotalAmount();
		System.out.printf("%-30s %-10s %-10s %-10.2f\n", "", "", "Total:", total);
		System.out.printf("%-30s %-10s %-10s %-10.2f\n", "", "", "Discount:", order.getDiscount());
		System.out.printf("%-30s %-10s %-10s %-10.2f\n", "", "", "Final Total:", total - order.getDiscount());

		System.out.println("\nPayment Mode: " + order.getPaymentMode());
		System.out.println("Delivery Partner: " + order.getDeliveryPartner());
		System.out.println("==============================\n");
	}
	
}
