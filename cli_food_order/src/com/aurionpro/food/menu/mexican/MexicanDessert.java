package com.aurionpro.food.menu.mexican;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.aurionpro.food.model.Food;
import com.aurionpro.food.model.IFoodType;

public class MexicanDessert implements IFoodType {

    @Override
    public String getSectionName() {
        return "Desserts";
    }

    @Override
    public List<Food> getFoodItems() {
		return new ArrayList<>(Arrays.asList(
            new Food(703, "Churros", 110),
            new Food(704, "Tres Leches Cake", 130)
        ));
    }
}
