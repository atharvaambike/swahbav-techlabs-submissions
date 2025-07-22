package com.aurionpro.food.menu;

import java.util.ArrayList;
import java.util.List;

import com.aurionpro.food.menu.japanese.JapaneseAppetizers;
import com.aurionpro.food.menu.japanese.JapaneseDessert;
import com.aurionpro.food.menu.japanese.JapaneseSushi;
import com.aurionpro.food.model.IFoodType;

public class JapaneseCuisine implements ICuisine {

    private List<IFoodType> sections;

    public JapaneseCuisine() {
        sections = new ArrayList<>();
        sections.add(new JapaneseAppetizers());
        sections.add(new JapaneseSushi());
        sections.add(new JapaneseDessert());
    }

    @Override
    public String getCuisineName() {
        return "Japanese";
    }

    @Override
    public List<IFoodType> getMenuSections() {
        return sections;
    }
}
