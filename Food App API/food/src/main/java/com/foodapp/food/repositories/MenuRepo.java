package com.foodapp.food.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.foodapp.food.daos.MenuDao;

public interface MenuRepo extends JpaRepository<MenuDao, UUID>{
	
	public Optional<MenuDao> findByMenuCardName(String menuName);
	
	public Optional<MenuDao> findByAdminEmail(String email);

	public Optional<MenuDao> findByRestaurantName(String restaurantName);

}
