package com.aurionpro.driver;

import java.util.Arrays;
import java.util.List;

import com.aurionpro.admin.AdminService;
import com.aurionpro.customer.CustomerService;
import com.aurionpro.delivery.DeliveryPartnerManager;
import com.aurionpro.discount.DiscountConfig;
import com.aurionpro.food.manager.FoodManager;
import com.aurionpro.food.menu.ICuisine;
import com.aurionpro.food.menu.IndianCuisine;
import com.aurionpro.food.menu.ItalianCuisine;
import com.aurionpro.food.menu.JapaneseCuisine;
import com.aurionpro.food.menu.MexicanCuisine;
import com.aurionpro.helper.InputValidator;
import com.aurionpro.shared.MenuService;

public class Driver {

	public static void main(String[] args) {

		List<ICuisine> cuisines = Arrays.asList(new IndianCuisine(), new ItalianCuisine(), new JapaneseCuisine(),
				new MexicanCuisine());

		FoodManager foodManager = new FoodManager(cuisines);
		MenuService menuService = new MenuService(foodManager);

		DiscountConfig discountConfig = new DiscountConfig(500, 50);
		DeliveryPartnerManager deliveryManager = new DeliveryPartnerManager(
				Arrays.asList("Zomato", "Swiggy", "Dunzo", "EatClub"));

		while (true) {
			System.out.println("\n=== Welcome to Mini Food Ordering App ===");
			System.out.println("Choose your role:");
			System.out.println("1. Admin");
			System.out.println("2. Customer");
			System.out.println("3. Exit");

			int choice = InputValidator.safeIntInput("Enter choice: ");

			switch (choice) {
			case 1 -> {
				AdminService admin = new AdminService(foodManager, menuService, discountConfig, deliveryManager);
				admin.showAdminMenu();
			}
			case 2 -> {
				CustomerService customer = new CustomerService(foodManager, menuService, discountConfig);
				customer.showCustomerMenu();
			}
			case 3 -> {
				System.out.println("Thank you! Exiting...");
				return;
			}
			default -> System.out.println("Invalid choice. Please try again.");
			}

			System.out.println("\n-------------------------------\n");
		}
	}
}
