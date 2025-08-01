package com.aurionpro.food.menu;

import java.util.ArrayList;
import java.util.List;

import com.aurionpro.food.menu.indian.IndianAppetizers;
import com.aurionpro.food.menu.indian.IndianDesserts;
import com.aurionpro.food.model.IFoodType;

public class IndianCuisine implements ICuisine {

    private List<IFoodType> sections;

    public IndianCuisine() {
        sections = new ArrayList<>();
        sections.add(new IndianAppetizers());
        sections.add(new IndianDesserts());
    }

    @Override
    public String getCuisineName() {
        return "Indian";
    }

    @Override
    public List<IFoodType> getMenuSections() {
        return sections;
    }
}
