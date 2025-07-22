package com.aurionpro.food.menu.mexican;

import java.util.ArrayList;
import com.aurionpro.food.model.AbstractFoodType;
import com.aurionpro.food.model.Food;

public class MexicanDessert extends AbstractFoodType {

    @Override
    public String getSectionName() {
        return "Dessert";
    }

    public MexicanDessert() {
        foodItems = new ArrayList<>();
        foodItems.add(new Food(1, "Churros", 130));
        foodItems.add(new Food(2, "Tres Leches Cake", 160));
    }
}
