package com.aurionpro.order.model;

import com.aurionpro.food.model.Food;

public class OrderItem {
    private Food food;
    private int quantity;

    public OrderItem(Food food, int quantity) {
        this.food = food;
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return food.getPrice() * quantity;
    }

    public Food getFood() {
        return food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
