package com.aurionpro.food.menu.japanese;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.aurionpro.food.model.AbstractFoodType;
import com.aurionpro.food.model.Food;
import com.aurionpro.food.model.IFoodType;

public class JapaneseSushi extends AbstractFoodType {

	@Override
	public String getSectionName() {
		return "Sushi";
	}

	public JapaneseSushi() {
		foodItems = new ArrayList<>();
		foodItems.add(new Food(453, "Mochi Ice Cream", 120));
		foodItems.add(new Food(634, "Dorayaki", 100));
	}

}
