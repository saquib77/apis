package com.foodapp.food.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodapp.food.daos.OrderStatusDao;

public interface OrderStatusRepo extends JpaRepository<OrderStatusDao, UUID>{
	
	public List<OrderStatusDao> findByRestaurantName(String restaurantName);
}
