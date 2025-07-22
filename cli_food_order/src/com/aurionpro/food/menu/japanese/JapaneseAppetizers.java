package com.aurionpro.food.menu.japanese;

import java.util.ArrayList;
import java.util.List;

import com.aurionpro.food.model.AbstractFoodType;
import com.aurionpro.food.model.Food;
import com.aurionpro.food.model.IFoodType;

public class JapaneseAppetizers  extends AbstractFoodType{


    public JapaneseAppetizers() {
        foodItems = new ArrayList<>();
        foodItems.add(new Food(601, "Miso soup", 80));
        foodItems.add(new Food(602, "Dimsums", 140));
    }

    @Override
    public String getSectionName() {
        return "Appetizers";
    }
}
