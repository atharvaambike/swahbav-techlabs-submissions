package com.aurionpro.food.menu.mexican;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.aurionpro.food.model.Food;
import com.aurionpro.food.model.IFoodType;

public class MexicanAppetizers implements IFoodType {

    @Override
    public String getSectionName() {
        return "Appetizers";
    }

    @Override
    public List<Food> getFoodItems() {
		return new ArrayList<>(Arrays.asList(
            new Food(701, "Guacamole", 100),
            new Food(702, "Quesadillas", 160)
        ));
    }
}
