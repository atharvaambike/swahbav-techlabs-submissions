package com.aurionpro.food.model;

import java.util.List;

public abstract class AbstractFoodType implements IFoodType {

	protected List<Food> foodItems;

	@Override
	public List<Food> getFoodItems() {
		return foodItems;
	}
	
	public void removeFood(Food food) {
		foodItems.remove(food);
	}


}
