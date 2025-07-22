package com.aurionpro.food.manager;

import com.aurionpro.food.menu.ICuisine;
import com.aurionpro.food.model.Food;
import com.aurionpro.food.model.IFoodType;

import java.util.List;

public class FoodManager {
	private List<ICuisine> cuisines;

	public FoodManager(List<ICuisine> cuisines) {
		this.cuisines = cuisines;
	}

	public ICuisine getCuisineByName(String name) {
		return cuisines.stream().filter(c -> c.getCuisineName().equalsIgnoreCase(name)).findFirst().orElse(null);
	}
	
	public List<ICuisine> getCuisines() {
	    return cuisines;
	}

}
