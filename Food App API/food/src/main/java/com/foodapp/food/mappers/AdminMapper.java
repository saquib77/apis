package com.foodapp.food.mappers;

import com.foodapp.food.daos.AdminDao;
import com.foodapp.food.models.Admin;

public class AdminMapper {
	public static AdminDao AdminUpdater(AdminDao adminDao,Admin admin) {
		adminDao.setId(admin.getId()!=null ? admin.getId() : adminDao.getId());
		adminDao.setEmail(admin.getEmail()!=null ? admin.getEmail() : adminDao.getEmail());
		adminDao.setName(admin.getName()!=null? admin.getName() : adminDao.getName());
		adminDao.setPhnum(admin.getPhnum()!=null ? admin.getPhnum() : adminDao.getPhnum());
		adminDao.setCreated(admin.getCreated()!=null ? admin.getCreated() : adminDao.getCreated());
		adminDao.setUpdated(admin.getUpdated()!=null ? admin.getUpdated() : adminDao.getUpdated());
		return adminDao;
	}
	
	public static AdminDao AdminToAdminDao(Admin admin) {
		AdminDao adminDao = new AdminDao();
		adminDao.setId(admin.getId());
		adminDao.setName(admin.getName());
		adminDao.setEmail(admin.getEmail());
		adminDao.setPassword(admin.getPassword());
		adminDao.setPhnum(admin.getPhnum());
		adminDao.setCreated(admin.getCreated());
		adminDao.setUpdated(admin.getUpdated());
		return adminDao;
	}
	
	public static Admin AdminDaoToAdmin(AdminDao adminDaoUp) {
		Admin admin = new Admin();
		admin.setId(adminDaoUp.getId());
		admin.setName(adminDaoUp.getName());
		admin.setEmail(adminDaoUp.getEmail());
		admin.setPhnum(adminDaoUp.getPhnum());
		admin.setCreated(adminDaoUp.getCreated());
		admin.setUpdated(adminDaoUp.getUpdated());
		return admin;
	}
}
