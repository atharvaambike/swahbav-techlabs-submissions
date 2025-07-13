package com.aurionpro.food.menu.italian;

import java.util.ArrayList;
import java.util.List;

import com.aurionpro.food.model.Food;
import com.aurionpro.food.model.IFoodType;

public class ItalianAppetizers implements IFoodType {

    private List<Food> foodItems;

    public ItalianAppetizers() {
        foodItems = new ArrayList<>();
        foodItems.add(new Food(301, "Bruschetta", 130));
        foodItems.add(new Food(302, "Garlic Bread", 90));
    }

    @Override
    public String getSectionName() {
        return "Appetizers";
    }

    @Override
    public List<Food> getFoodItems() {
        return foodItems;
    }
}
