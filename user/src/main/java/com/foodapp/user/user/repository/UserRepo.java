package com.foodapp.user.user.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodapp.user.user.daos.UserDao;


public interface UserRepo extends JpaRepository<UserDao, UUID> {

	Optional<UserDao> findByEmail(String email);
}
