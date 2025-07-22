package com.aurionpro.food.menu.indian;

import com.aurionpro.food.model.AbstractFoodType;
import com.aurionpro.food.model.Food;
import com.aurionpro.food.model.IFoodType;

import java.util.ArrayList;
import java.util.List;

public class IndianAppetizers extends AbstractFoodType {


	public IndianAppetizers() {
		foodItems = new ArrayList<>();
		foodItems.add(new Food(101, "Samosa", 30));
		foodItems.add(new Food(102, "Paneer Tikka", 120));
	}

	@Override
	public String getSectionName() {
		return "Appetizers";
	}
}
