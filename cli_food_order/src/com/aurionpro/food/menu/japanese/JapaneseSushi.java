package com.aurionpro.food.menu.japanese;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.aurionpro.food.model.Food;
import com.aurionpro.food.model.IFoodType;

public class JapaneseSushi implements IFoodType {

    @Override
    public String getSectionName() {
        return "Sushi";
    }

    @Override
    public List<Food> getFoodItems() {
        return new ArrayList<>(Arrays.asList(
            new Food(605, "California Roll", 220),
            new Food(606, "Salmon Nigiri", 200)
        ));
    }

}
