package com.aurionpro.food.menu;

import java.util.ArrayList;
import java.util.List;

import com.aurionpro.food.menu.mexican.MexicanAppetizers;
import com.aurionpro.food.menu.mexican.MexicanDessert;
import com.aurionpro.food.menu.mexican.MexicanSides;
import com.aurionpro.food.model.IFoodType;

public class MexicanCuisine implements ICuisine {

    private List<IFoodType> sections;

    public MexicanCuisine() {
        sections = new ArrayList<>();
        sections.add(new MexicanAppetizers());
        sections.add(new MexicanSides());
        sections.add(new MexicanDessert());
    }

    @Override
    public String getCuisineName() {
        return "Mexican";
    }

    @Override
    public List<IFoodType> getMenuSections() {
        return sections;
    }
}
