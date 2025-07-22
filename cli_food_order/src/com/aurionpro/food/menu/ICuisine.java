package com.aurionpro.food.menu;

import java.util.List;
import com.aurionpro.food.model.IFoodType;

public interface ICuisine {

	String getCuisineName();

	List<IFoodType> getMenuSections();
}