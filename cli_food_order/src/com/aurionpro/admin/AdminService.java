package com.aurionpro.admin;

import java.util.List;

import com.aurionpro.delivery.DeliveryPartnerManager;
import com.aurionpro.discount.DiscountConfig;
import com.aurionpro.food.manager.FoodManager;
import com.aurionpro.food.menu.ICuisine;
import com.aurionpro.food.model.Food;
import com.aurionpro.food.model.IFoodType;
import com.aurionpro.helper.FoodIdGenerator;
import com.aurionpro.helper.InputValidator;
import com.aurionpro.shared.MenuService;

public class AdminService {

	private FoodManager foodManager;
	private MenuService menuService;
	private DiscountConfig discountConfig;
	private DeliveryPartnerManager deliveryManager;

	public AdminService(FoodManager foodManager, MenuService menuService, DiscountConfig discountConfig,
			DeliveryPartnerManager deliveryManager) {
		this.foodManager = foodManager;
		this.menuService = menuService;
		this.discountConfig = discountConfig;
		this.deliveryManager = deliveryManager;
	}

	public void showAdminMenu() {
		while (true) {
			System.out.println("\n[Admin Menu]");
			System.out.println("1. View All Cuisines and Menus");
			System.out.println("2. Add Food Item");
			System.out.println("3. Remove Food Item");
			System.out.println("4. Update Food Item");
			System.out.println("5. View/Update Discount Settings");
			System.out.println("6. Manage Delivery Partners");
			System.out.println("7. Exit Admin Panel");

			int choice = InputValidator.safeIntInput("Enter choice: ");

			switch (choice) {
			case 1 -> menuService.viewAllMenus();
			case 2 -> addFoodItem();
			case 3 -> {
				menuService.viewAllMenus();
				removeFoodItem();
			}
			case 4 -> updateFoodItem();
			case 5 -> updateDiscountSettings();
			case 6 -> manageDeliveryPartners();
			case 7 -> {
				System.out.println("Exiting Admin Panel.");
				return;
			}
			default -> System.out.println("Invalid choice.");
			}
		}
	}

	private void addFoodItem() {
		ICuisine cuisine = menuService.promptCuisine();
		if (cuisine == null) {
			System.out.println("Invalid cuisine selection.");
			return;
		}

		IFoodType section = menuService.promptSection(cuisine);
		if (section == null) {
			System.out.println("Invalid section.");
			return;
		}

		int id = FoodIdGenerator.getNextId();
		System.out.println("Auto-generated Food ID: " + id);
		String name = InputValidator.safeStringInput("Enter Food Name: ");
		double price = InputValidator.safeDoubleInput("Enter Price: ");

		section.getFoodItems().add(new Food(id, name, price));
		System.out.println("Food item added successfully!");
	}

	private void removeFoodItem() {
		ICuisine cuisine = menuService.promptCuisine();
		System.out.println("aaaa");
		if (cuisine == null) {
			System.out.println("Invalid cuisine selection.");
			return;
		}

		IFoodType section = menuService.promptSection(cuisine);
		if (section == null) {
			System.out.println("Invalid section.");
			return;
		}

		int foodId = InputValidator.safeIntInput("Enter Food ID to remove: ");

		List<Food> foodItems = section.getFoodItems();
		Food toRemove = null;

		for (Food food : foodItems) {
			System.out.println(food.getName());
		}
		for (Food foo : foodItems) {
			if (foo.getId() == foodId) {
				toRemove = foo;
				break;
			}
		}

		System.out.println(toRemove);
		if (toRemove != null) {
			foodItems.remove(toRemove);
			section.removeFood(toRemove);
			System.out.println("Food item removed successfully.");
			for (Food food : foodItems) {
				System.out.println(food.getName());
			}
			List<Food> foodItems2 = section.getFoodItems();

			for (Food food : foodItems2) {
				System.out.println(food.getName());
			}
		} else {
			System.out.println("Food item not found.");
		}
	}

	private void updateFoodItem() {
		ICuisine cuisine = menuService.promptCuisine();
		if (cuisine == null) {
			System.out.println("Invalid cuisine selection.");
			return;
		}

		IFoodType section = menuService.promptSection(cuisine);
		if (section == null) {
			System.out.println("Invalid section.");
			return;
		}

		int id = InputValidator.safeIntInput("Enter Food ID to update: ");
		List<Food> items = section.getFoodItems();
		Food toUpdate = items.stream().filter(f -> f.getId() == id).findFirst().orElse(null);

		if (toUpdate == null) {
			System.out.println("Food item not found.");
			return;
		}

		String newName = InputValidator.safeStringInput("Enter new name: ");
		double newPrice = InputValidator.safeDoubleInput("Enter new price: ");

		items.remove(toUpdate);
		items.add(new Food(id, newName, newPrice));
		System.out.println("Food item updated successfully.");
	}

	private void updateDiscountSettings() {
		System.out.println("\nCurrent Discount Settings:");
		System.out.println("Threshold: ₹" + discountConfig.getThreshold());
		System.out.println("Discount Amount: ₹" + discountConfig.getDiscountAmount());

		String newThreshold = InputValidator.safeStringInput("Enter new threshold (or press Enter to skip): ");
		if (!newThreshold.trim().isEmpty()) {
			discountConfig.setThreshold(Double.parseDouble(newThreshold));
		}

		String newDiscount = InputValidator.safeStringInput("Enter new discount amount (or press Enter to skip): ");
		if (!newDiscount.trim().isEmpty()) {
			discountConfig.setDiscountAmount(Double.parseDouble(newDiscount));
		}

		System.out.println("Discount settings updated!");
	}

	private void manageDeliveryPartners() {
		while (true) {
			System.out.println("\n[Delivery Partner Management]");
			System.out.println("1. View Partners");
			System.out.println("2. Add Partner");
			System.out.println("3. Remove Partner");
			System.out.println("4. Back");

			int choice = InputValidator.safeIntInput("Enter choice: ");

			switch (choice) {
			case 1 -> {
				System.out.println("Current Partners:");
				deliveryManager.getAllPartners().forEach(System.out::println);
			}
			case 2 -> {
				String name = InputValidator.safeStringInput("Enter name to add: ");
				deliveryManager.addPartner(name);
				System.out.println("Partner added.");
			}
			case 3 -> {
				String name = InputValidator.safeStringInput("Enter name to remove: ");
				boolean removed = deliveryManager.removePartner(name);
				System.out.println(removed ? "Partner removed." : "Partner not found.");
			}
			case 4 -> {
				return;
			}
			default -> System.out.println("Invalid choice.");
			}
		}
	}
}
