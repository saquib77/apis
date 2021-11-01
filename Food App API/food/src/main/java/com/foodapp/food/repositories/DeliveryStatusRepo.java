package com.foodapp.food.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodapp.food.daos.DeliveryStatusDao;

public interface DeliveryStatusRepo extends JpaRepository<DeliveryStatusDao, UUID>{
	Optional<List<DeliveryStatusDao>> findByDeliveryPersonName(String name);
}
