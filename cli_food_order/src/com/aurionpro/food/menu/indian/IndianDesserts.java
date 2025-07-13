package com.aurionpro.food.menu.indian;

import java.util.ArrayList;
import java.util.List;

import com.aurionpro.food.model.Food;
import com.aurionpro.food.model.IFoodType;

public class IndianDesserts implements IFoodType {

    private List<Food> foodItems;

    public IndianDesserts() {
        foodItems = new ArrayList<>();
        foodItems.add(new Food(201, "Gulab Jamun", 40));
        foodItems.add(new Food(202, "Rasgulla", 45));
        foodItems.add(new Food(203, "Kheer", 55));
    }

    @Override
    public String getSectionName() {
        return "Desserts";
    }

    @Override
    public List<Food> getFoodItems() {
        return foodItems;
    }
}
