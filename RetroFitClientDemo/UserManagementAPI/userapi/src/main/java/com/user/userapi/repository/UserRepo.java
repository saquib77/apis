package com.user.userapi.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.userapi.dao.UserDao;

public interface UserRepo extends JpaRepository<UserDao, UUID>{
	Optional<UserDao> findByEmail(String email);
}
