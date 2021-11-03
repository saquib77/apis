package com.foodapp.food.services;

import java.util.Optional;


import com.foodapp.food.models.Dish;
import com.foodapp.food.models.Menu;

public interface MenuService {

	Optional<Menu> getMenu(String email);

	Optional<Menu> saveMenu(Menu menu);

	Optional<Menu> addDish(String menuName, Dish dish);

	Optional<Menu> updateDish(String menuName, Dish dish);

	Optional<Dish> findDish(String menuName,String dishName);

	Optional<Menu> deleteDish(String menuName, String dishName);

	Optional<Menu> fetchMenuByRestaurant(String restaurantName);
}
