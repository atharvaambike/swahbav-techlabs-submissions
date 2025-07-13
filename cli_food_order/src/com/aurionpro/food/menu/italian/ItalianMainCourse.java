package com.aurionpro.food.menu.italian;

import java.util.ArrayList;
import java.util.List;

import com.aurionpro.food.model.Food;
import com.aurionpro.food.model.IFoodType;

public class ItalianMainCourse implements IFoodType {

    private List<Food> foodItems;

    public ItalianMainCourse() {
        foodItems = new ArrayList<>();
        foodItems.add(new Food(501, "Spaghetti Carbonara", 250));
        foodItems.add(new Food(502, "Margherita Pizza", 300));
    }

    @Override
    public String getSectionName() {
        return "Main Course";
    }

    @Override
    public List<Food> getFoodItems() {
        return foodItems;
    }
}
