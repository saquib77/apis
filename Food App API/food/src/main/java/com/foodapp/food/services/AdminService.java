package com.foodapp.food.services;

import java.util.List;
import java.util.Optional;

import com.foodapp.food.models.*;

public interface AdminService {
	
	public Optional<Admin> registerAdmin(Admin admin);

	public Optional<Admin> updateAdminDetail(Admin admin);

	public Optional<Menu> saveMenu(Menu menu);

	public Optional<Menu> getMenu(String email);

	public Optional<List<Admin>> getList();

	public Optional<Menu> addDish(String menuName,Dish dish);

	public Optional<Menu> deleteDish(String menuName, String dishName);

	public Optional<Menu> updateDish(String menuName, Dish dish);

	public Optional<List<OrderStatus>> pendingOrders(String restaurantName);

	public Optional<List<OrderStatus>> approveOrder(String restaurantName);

	public Optional<DeliveryPerson> addDeliveryPerson(DeliveryPerson delPer);
}
