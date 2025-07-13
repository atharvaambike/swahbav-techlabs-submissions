package com.aurionpro.shared;

import java.util.List;

import com.aurionpro.food.manager.FoodManager;
import com.aurionpro.food.menu.ICuisine;
import com.aurionpro.food.model.Food;
import com.aurionpro.food.model.IFoodType;
import com.aurionpro.helper.InputValidator;

public class MenuService {
	private FoodManager foodManager;

	public MenuService(FoodManager foodManager) {
		this.foodManager = foodManager;
	}

	public void viewAllMenus() {
		System.out.println("\n========== MENU ==========\n");

		for (ICuisine cuisine : foodManager.getCuisines()) {
			System.out.println("Cuisine: " + cuisine.getCuisineName());

			for (IFoodType section : cuisine.getMenuSections()) {
				System.out.println("  Section: " + section.getSectionName());
				System.out.printf("    %-10s %-30s %10s\n", "ID", "Food Item", "Price (₹)");
				System.out.println("    -------------------------------------------------------------");
				for (Food food : section.getFoodItems()) {
					System.out.printf("    %-10d %-30s %10.2f\n", food.getId(), food.getName(), food.getPrice());
				}
				System.out.println();
			}
		}
		System.out.println("===========================\n");
	}

	public ICuisine promptCuisine() {
		System.out.println("Available Cuisines:");
		List<ICuisine> cuisines = foodManager.getCuisines();
		for (int i = 0; i < cuisines.size(); i++) {
			System.out.println((i + 1) + ". " + cuisines.get(i).getCuisineName());
		}
		int choice = InputValidator.safeIntInput("Choose a cuisine: ");
		if (choice < 1 || choice > cuisines.size())
			return null;
		return cuisines.get(choice - 1);
	}

	public IFoodType promptSection(ICuisine cuisine) {
		List<IFoodType> sections = cuisine.getMenuSections();
		for (int i = 0; i < sections.size(); i++) {
			System.out.println((i + 1) + ". " + sections.get(i).getSectionName());
		}
		int choice = InputValidator.safeIntInput("Choose a section: ");
		if (choice < 1 || choice > sections.size())
			return null;
		return sections.get(choice - 1);
	}

	public void showFoodItems(IFoodType section) {
		System.out.printf("\nItems in %s:\n", section.getSectionName());
		System.out.printf("%-10s %-30s %-10s\n", "ID", "Name", "Price(₹)");
		for (Food food : section.getFoodItems()) {
			System.out.printf("%-10d %-30s %-10.2f\n", food.getId(), food.getName(), food.getPrice());
		}
		System.out.println();
	}
}
