package com.aurionpro.food.menu.italian;

import java.util.ArrayList;
import java.util.List;

import com.aurionpro.food.model.AbstractFoodType;
import com.aurionpro.food.model.Food;
import com.aurionpro.food.model.IFoodType;

public class ItalianDessert  extends AbstractFoodType {


    public ItalianDessert() {
        foodItems = new ArrayList<>();
        foodItems.add(new Food(401, "Tiramisu", 150));
        foodItems.add(new Food(402, "Cannoli", 140));
    }

    @Override
    public String getSectionName() {
        return "Desserts";
    }
}
