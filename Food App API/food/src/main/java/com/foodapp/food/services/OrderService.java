package com.foodapp.food.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.foodapp.food.models.Menu;
import com.foodapp.food.models.OrderStatus;
import com.foodapp.food.models.UserOrder;

public interface OrderService{

	Optional<OrderStatus> palceOrder(UserOrder order);

	Optional<OrderStatus> getOrder(UUID id);

	Optional<List<OrderStatus>> approveOrder(OrderStatus order);

	Optional<List<OrderStatus>> pendingOrders(String restaurantName);

}
