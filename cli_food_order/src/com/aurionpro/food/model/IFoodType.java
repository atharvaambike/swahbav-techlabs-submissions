package com.aurionpro.food.model;

import java.util.List;

public interface IFoodType {
	String getSectionName();

	List<Food> getFoodItems();

	void removeFood(Food food);

}