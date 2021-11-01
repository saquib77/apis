package com.foodapp.food.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodapp.food.daos.UserDao;

public interface UserRepo extends JpaRepository<UserDao, UUID> {

	Optional<UserDao> findByEmail(String email);
}
