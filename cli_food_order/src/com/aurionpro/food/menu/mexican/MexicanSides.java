package com.aurionpro.food.menu.mexican;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.aurionpro.food.model.Food;
import com.aurionpro.food.model.IFoodType;

public class MexicanSides implements IFoodType {

	@Override
	public String getSectionName() {
		return "Sides";
	}

	@Override
	public List<Food> getFoodItems() {
		return new ArrayList<>(Arrays.asList(
				new Food(705, "Nachos", 150), 
				new Food(706, "Taco Bites", 180)
				));
	}
}
