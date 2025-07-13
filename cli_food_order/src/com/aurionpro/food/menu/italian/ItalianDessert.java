package com.aurionpro.food.menu.italian;

import java.util.ArrayList;
import java.util.List;

import com.aurionpro.food.model.Food;
import com.aurionpro.food.model.IFoodType;

public class ItalianDessert implements IFoodType {

    private List<Food> foodItems;

    public ItalianDessert() {
        foodItems = new ArrayList<>();
        foodItems.add(new Food(401, "Tiramisu", 150));
        foodItems.add(new Food(402, "Cannoli", 140));
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
