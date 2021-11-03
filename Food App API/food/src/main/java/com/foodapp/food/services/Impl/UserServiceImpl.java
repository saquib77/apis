package com.foodapp.food.services.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.food.daos.AddressDao;
import com.foodapp.food.daos.UserDao;
import com.foodapp.food.mappers.UserMapper;
import com.foodapp.food.models.Address;
import com.foodapp.food.models.User;
import com.foodapp.food.repositories.UserRepo;
import com.foodapp.food.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	
	
	@Override
	public Optional<User> addUser(User user) {
		Optional<UserDao> userDaoDb = userRepo.findByEmail(user.getEmail());
		if(userDaoDb.isEmpty()) {
			user.setCreated(new Date());
			user.setUpdated(new Date());
			user.getAddress().setCreated(new Date());
			user.getAddress().setUpdated(new Date());
			UserDao userDao =  userRepo.save(UserMapper.UserToUserDao(user));
			return Optional.of(UserMapper.UserDaoToUser(userDao));
		}
		return Optional.empty();
	}

	@Override
	public Optional<List<User>> getUserList() {
		List<UserDao> userDaoDb = userRepo.findAll();
		if(!userDaoDb.isEmpty()) {
			List<User> userList = new ArrayList<>();
			for(UserDao d : userDaoDb) {
				userList.add(UserMapper.UserDaoToUser(d));
			}
			return Optional.of(userList);
		}
		return Optional.empty();
	}
	
	public Optional<User> getUserById(UUID id){
		Optional<UserDao> user = userRepo.findById(id);
		if(user.isPresent()){
			User userdb = UserMapper.UserDaoToUser(user.get());
			return Optional.of(userdb);
		}
		return Optional.empty();
	}

	public Optional<User> updateUser(UUID id,User user){
		Optional<UserDao> userdb = userRepo.findById(id);
		if(userdb.isPresent()) {
			UserDao userDao = UserMapper.UserToUserDao(user);
			AddressDao userAdDao = new AddressDao();
			user.getAddress().setUpdated(new Date());
			userAdDao = UserMapper.AddressToAddressDao(userAdDao,user.getAddress());
			UserDao userUpDao = new UserDao();
			userUpDao = userDao;
			userUpDao.setAddress(userAdDao);
			userUpDao.setUpdated(new Date());
			userRepo.save(userUpDao);
			return Optional.of(UserMapper.UserDaoToUser(userUpDao));
		}
		return Optional.empty();
	}
	public Optional<User> deleteUser(UUID id) {
		Optional<UserDao> userdb = userRepo.findById(id);
		if(userdb.isPresent()) {
			UserDao userDbDao = userdb.get();
			userRepo.delete(userDbDao);
			return Optional.of(UserMapper.UserDaoToUser(userDbDao));
		}
		return Optional.empty();
	}
	public Optional<User> updateUserAddress(UUID id,Address address) {
		Optional<UserDao> userDaoDb = userRepo.findById(id);
		if(userDaoDb.isPresent()) {
			UserDao userDb = userDaoDb.get();
			AddressDao addDao = userDaoDb.get().getAddress();
			addDao.setUpdated(new Date());
			userDb.setAddress(UserMapper.AddressToAddressDao(addDao, address));
			userDb.getAddress().setUpdated(new Date());
			userRepo.save(userDb);
			return Optional.of(UserMapper.UserDaoToUser(userDb));
		}
		return Optional.empty();
	}
	
	public Optional<User> updateUserDetails(UUID id, User user){
		Optional<UserDao> userDaoDb = userRepo.findById(id);
		if(userDaoDb.isPresent()) {
			userDaoDb.get().setUpdated(new Date());
			UserDao userDetails = UserMapper.UserToUserDao(userDaoDb.get(), user);
			userRepo.save(userDetails);
			return Optional.of(UserMapper.UserDaoToUser(userDetails));
		}
		return Optional.empty();
	}

	

	

	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
