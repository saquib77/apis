package com.foodapp.food.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.foodapp.food.models.*;

public interface AdminService {
	
	
	public Optional<List<Admin>> getList();

	public Optional<Admin> registerAdmin(Admin admin);

	public Optional<Admin> updateAdminDetail(Admin admin);

	public Optional<Admin> delete(UUID id);

	public Optional<Admin> getById(UUID id);
}
