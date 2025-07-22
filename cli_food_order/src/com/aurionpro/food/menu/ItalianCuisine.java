package com.aurionpro.food.menu;

import java.util.ArrayList;
import java.util.List;

import com.aurionpro.food.menu.italian.ItalianAppetizers;
import com.aurionpro.food.menu.italian.ItalianDessert;
import com.aurionpro.food.menu.italian.ItalianMainCourse;
import com.aurionpro.food.model.IFoodType;

public class ItalianCuisine implements ICuisine {

    private List<IFoodType> sections;

    public ItalianCuisine() {
        sections = new ArrayList<>();
        sections.add(new ItalianMainCourse());
        sections.add(new ItalianDessert());
        sections.add(new ItalianAppetizers());

    }

    @Override
    public String getCuisineName() {
        return "Italian";
    }

    @Override
    public List<IFoodType> getMenuSections() {
        return sections;
    }
}
