package com.foodapp.food.services;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.foodapp.food.models.Address;
import com.foodapp.food.models.User;


public interface UserService {

	Optional<User> addUser(User user);

	Optional<List<User>> getUserList();

	Optional<User> getUserById(UUID id);

	Optional<User> updateUser(UUID id, User user);

	Optional<User> deleteUser(UUID id);

	Optional<User> updateUserAddress(UUID id, Address address);

	Optional<User> updateUserDetails(UUID id, User user);

}
