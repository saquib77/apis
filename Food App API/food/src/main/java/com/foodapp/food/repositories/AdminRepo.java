package com.foodapp.food.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodapp.food.daos.AdminDao;

public interface AdminRepo extends JpaRepository<AdminDao, UUID>{
	
	public Optional<AdminDao> findAdminByEmail(String email);
}
