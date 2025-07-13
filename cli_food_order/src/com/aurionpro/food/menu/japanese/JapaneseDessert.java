package com.aurionpro.food.menu.japanese;

import java.util.ArrayList;
import java.util.List;

import com.aurionpro.food.model.Food;
import com.aurionpro.food.model.IFoodType;

public class JapaneseDessert implements IFoodType {

    private List<Food> foodItems;

    public JapaneseDessert() {
        foodItems = new ArrayList<>();
        foodItems.add(new Food(603, "Mochi Ice Cream", 120));
        foodItems.add(new Food(604, "Dorayaki", 100));
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
