package com.aurionpro.food.menu;

import com.aurionpro.food.model.IFoodType;
import com.aurionpro.food.menu.italian.ItalianMainCourse;
import java.util.Arrays;
import java.util.List;

public class ItalianCuisine implements ICuisine {
    @Override
    public String getCuisineName() {
        return "Italian";
    }

    @Override
    public List<IFoodType> getMenuSections() {
        return Arrays.asList(new ItalianMainCourse());
    }
}
