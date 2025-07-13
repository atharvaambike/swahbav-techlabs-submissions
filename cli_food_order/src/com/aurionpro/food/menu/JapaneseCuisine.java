package com.aurionpro.food.menu;

import com.aurionpro.food.model.IFoodType;
import com.aurionpro.food.menu.japanese.JapaneseSushi;
import java.util.Arrays;
import java.util.List;

public class JapaneseCuisine implements ICuisine {
    @Override
    public String getCuisineName() {
        return "Japanese";
    }

    @Override
    public List<IFoodType> getMenuSections() {
        return Arrays.asList(new JapaneseSushi());
    }
}