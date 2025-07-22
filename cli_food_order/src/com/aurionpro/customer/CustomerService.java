package com.aurionpro.customer;

import com.aurionpro.discount.DiscountConfig;
import com.aurionpro.discount.FlatDiscount;
import com.aurionpro.discount.IDiscountStrategy;
import com.aurionpro.food.manager.FoodManager;
import com.aurionpro.food.menu.ICuisine;
import com.aurionpro.food.model.Food;
import com.aurionpro.food.model.IFoodType;
import com.aurionpro.helper.InputValidator;
import com.aurionpro.helper.Print;
import com.aurionpro.helper.Utils;
import com.aurionpro.order.model.Order;
import com.aurionpro.order.model.OrderItem;
import com.aurionpro.payment.CashPayment;
import com.aurionpro.payment.IPaymentStrategy;
import com.aurionpro.payment.UPIPayment;
import com.aurionpro.shared.MenuService;

public class CustomerService {

	private MenuService menuService;
	private FoodManager foodManager;
	private DiscountConfig discountConfig;

	public CustomerService(FoodManager foodManager, MenuService menuService, DiscountConfig discountConfig) {
		this.foodManager = foodManager;
		this.menuService = menuService;
		this.discountConfig = discountConfig;
	}

	public void showCustomerMenu() {
		Order order = new Order();

		while (true) {
			System.out.println("\n[Customer Menu]");
			System.out.println("1. View Menu");
			System.out.println("2. Browse & Add Items to Cart");
			System.out.println("3. View Cart");
			System.out.println("4. Checkout");
			System.out.println("5. Exit");

			int choice = InputValidator.safeIntInput("Enter choice: ");

			switch (choice) {
			case 1 -> menuService.viewAllMenus();
			case 2 -> browseAndAdd(order);
			case 3 -> viewCart(order);
			case 4 -> {
				processCheckout(order);
				return;
			}
			case 5 -> {
				System.out.println("Thank you for visiting!");
				return;
			}
			default -> System.out.println("Invalid choice.");
			}
		}
	}

	private void browseAndAdd(Order order) {
		ICuisine cuisine = menuService.promptCuisine();
		if (cuisine == null)
			return;

		IFoodType section = menuService.promptSection(cuisine);
		if (section == null)
			return;

		menuService.showFoodItems(section);

		int foodId = InputValidator.safeIntInput("Enter Food ID to add to cart: ");
		Food selected = section.getFoodItems().stream().filter(f -> f.getId() == foodId).findFirst().orElse(null);

		if (selected != null) {
			int qty = InputValidator.safeIntInput("Enter quantity: ");
//			order.addItem(new OrderItem(selected, qty));
			boolean found = false;
			for (OrderItem item : order.getOrderItems()) {
				if (item.getFood().getId() == selected.getId()) {
					item.setQuantity(item.getQuantity() + qty);
					found = true;
					break;
				}
			}

			if (!found) {
				order.addItem(new OrderItem(selected, qty));
			}

			System.out.println("Item added to cart.");
		} else {
			System.out.println("Invalid food ID.");
		}
	}

	private void viewCart(Order order) {
		if (order.getOrderItems().isEmpty()) {
			System.out.println("\nCart is empty.\n");
			return;
		}

		int totalItems = 0;
		double totalAmount = 0;

		System.out.println("\n--- Your Cart ---");
		for (OrderItem item : order.getOrderItems()) {
			System.out.printf("%-30s Qty: %-3d Subtotal: ₹%.2f\n", item.getFood().getName(), item.getQuantity(),
					item.getSubtotal());

			totalItems += item.getQuantity();
			totalAmount += item.getSubtotal();
		}

		System.out.println("----------------------");
		System.out.println("Total items: " + totalItems);
		System.out.printf("Current total: ₹%.2f\n", totalAmount);
		System.out.println();
	}

	private void processCheckout(Order order) {
		if (order.getOrderItems().isEmpty()) {
			System.out.println("Your cart is empty. Please add items before checkout.");
			return;
		}

		double total = order.calculateTotalAmount();
		IDiscountStrategy discountStrategy = new FlatDiscount(discountConfig);
		double discount = discountStrategy.calculateDiscount(total);
		order.setDiscount(discount);

		IPaymentStrategy paymentStrategy = getPaymentStrategyFromUser();
		paymentStrategy.pay(total - discount);
		order.setPaymentMode(paymentStrategy.getPaymentMode());

		order.setDeliveryPartner(Utils.assignRandomDeliveryPartner());

		Print.printInvoice(order);
	}

	private IPaymentStrategy getPaymentStrategyFromUser() {
		String input = InputValidator.safeStringInput("Enter payment mode (Cash/UPI): ").toLowerCase();

		return switch (input) {
		case "cash" -> new CashPayment();
		case "upi" -> new UPIPayment();
		default -> {
			System.out.println("Invalid payment mode. Defaulting to Cash.");
			yield new CashPayment();
		}
		};
	}
}
