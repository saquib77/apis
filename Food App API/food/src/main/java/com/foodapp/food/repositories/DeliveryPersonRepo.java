package com.foodapp.food.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodapp.food.daos.DeliveryPersonDao;

public interface DeliveryPersonRepo extends JpaRepository<DeliveryPersonDao, UUID>{
	Optional<DeliveryPersonDao> findByEmail(String email);
}
