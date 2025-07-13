package com.aurionpro.food.menu;

import com.aurionpro.food.model.IFoodType;
import com.aurionpro.food.menu.mexican.MexicanSides;
import java.util.Arrays;
import java.util.List;

public class MexicanCuisine implements ICuisine {
    @Override
    public String getCuisineName() {
        return "Mexican";
    }

    @Override
    public List<IFoodType> getMenuSections() {
        return Arrays.asList(new MexicanSides());
    }
}
