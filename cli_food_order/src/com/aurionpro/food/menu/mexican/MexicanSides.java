package com.aurionpro.food.menu.mexican;

import java.util.ArrayList;
import com.aurionpro.food.model.AbstractFoodType;
import com.aurionpro.food.model.Food;

public class MexicanSides extends AbstractFoodType {

    @Override
    public String getSectionName() {
        return "Sides";
    }

    public MexicanSides() {
        foodItems = new ArrayList<>();
        foodItems.add(new Food(1, "Guacamole", 90));
        foodItems.add(new Food(2, "Mexican Street Corn", 110));
    }
}
