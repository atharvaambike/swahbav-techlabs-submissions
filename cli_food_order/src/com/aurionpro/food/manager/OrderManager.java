package com.aurionpro.food.manager;

import com.aurionpro.order.model.Order;
import com.aurionpro.order.model.OrderItem;

import java.util.List;

public class OrderManager {

	public Order createOrder(List<OrderItem> items) {
		Order order = new Order(items);
		double total = items.stream().mapToDouble(OrderItem::getSubtotal).sum();
		order.setTotalAmount(total);

		if (total > 500) {
			order.setDiscount(50);
			order.setTotalAmount(total - 50);
		} else {
			order.setDiscount(0);
		}

		return order;
	}
}
