package com.foodapp.food.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.foodapp.food.daos.PaymentDao;

public interface PaymentRepo extends JpaRepository<PaymentDao, UUID> {

	Optional<PaymentDao> findByEmail(String email);
	
	@Query(value="select * from payment p where p.restaurant_name=?1",nativeQuery = true)
	List<PaymentDao> getPaymentByRestaurantName(String restaurantName);

}
