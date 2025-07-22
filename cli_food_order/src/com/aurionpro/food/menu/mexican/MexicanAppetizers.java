package com.aurionpro.food.menu.mexican;

import java.util.ArrayList;
import com.aurionpro.food.model.AbstractFoodType;
import com.aurionpro.food.model.Food;

public class MexicanAppetizers extends AbstractFoodType {

    @Override
    public String getSectionName() {
        return "Appetizers";
    }

    public MexicanAppetizers() {
        foodItems = new ArrayList<>();
        foodItems.add(new Food(1, "Nachos with Salsa", 120));
        foodItems.add(new Food(2, "Chicken Taquitos", 140));
        foodItems.add(new Food(3, "Queso Dip", 100));
    }
}
