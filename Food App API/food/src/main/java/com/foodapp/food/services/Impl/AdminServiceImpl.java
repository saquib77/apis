package com.foodapp.food.services.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foodapp.food.daos.AdminDao;
import com.foodapp.food.mappers.AdminMapper;
import com.foodapp.food.models.*;
import com.foodapp.food.repositories.AdminRepo;
import com.foodapp.food.services.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepo adminRepo;

	@Override
	public Optional<Admin> registerAdmin(Admin admin) {
		Optional<AdminDao> adminDao = adminRepo.findAdminByEmail(admin.getEmail());
		if(adminDao.isEmpty()) {
			admin.setCreated(new Date());
			admin.setUpdated(new Date());
			AdminDao adminDaoNew = adminRepo.save(AdminMapper.AdminToAdminDao(admin));
			return Optional.of(AdminMapper.AdminDaoToAdmin(adminDaoNew));
		}
		return Optional.empty();
	}

	@Override
	public Optional<Admin> updateAdminDetail(Admin admin) {
		Optional<AdminDao> adminDaoDb = adminRepo.findAdminByEmail(admin.getEmail());
		if(adminDaoDb.isPresent()) {
			AdminDao adminDaoUp = AdminMapper.AdminUpdater(adminDaoDb.get(),admin);
			adminDaoUp.setUpdated(new Date());
			adminRepo.save(adminDaoUp);
			return Optional.of(AdminMapper.AdminDaoToAdmin(adminDaoUp));
		}
		return Optional.empty();
	}

	@Override
	public Optional<List<Admin>> getList() {
		List<AdminDao> adminListDb = adminRepo.findAll();
		List<Admin> adminList = new ArrayList<>();
		if(!adminListDb.isEmpty()) {
			for(AdminDao d : adminListDb) {
				adminList.add(AdminMapper.AdminDaoToAdmin(d));
			}
			return Optional.of(adminList);
		}
		return Optional.empty();
		
	}

	@Override
	public Optional<Admin> delete(UUID id) {
		AdminDao admindb = adminRepo.getById(id);
		if(admindb!=null) {
			adminRepo.delete(admindb);
			return Optional.of(AdminMapper.AdminDaoToAdmin(admindb));
		}
		return Optional.empty();
	}

	@Override
	public Optional<Admin> getById(UUID id) {
		AdminDao admindb = adminRepo.getById(id);
		if(admindb!=null) {
			return Optional.of(AdminMapper.AdminDaoToAdmin(admindb));
		}
		return Optional.empty();
	}

	
}
