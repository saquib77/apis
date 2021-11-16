package com.user.userapi.services;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.userapi.dao.AddressDao;
import com.user.userapi.dao.UserDao;
import com.user.userapi.mapper.UserMapper;
import com.user.userapi.model.Address;
import com.user.userapi.model.LoginCred;
import com.user.userapi.model.User;
import com.user.userapi.repository.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;

	

	public Optional<List<User>> getAllUser() {
		List<UserDao> listDb = userRepo.findAll();
		List<User> list = new ArrayList<>();
		for(int i=0;i<listDb.size();i++) {
			UserDao userDao = listDb.get(i);
			list.add(UserMapper.UserDaoToUser(userDao));
		}
		return Optional.of(list);
	}
	
	public Optional<User> loginUserByEmailAndPass(LoginCred loginCred) {
		Optional<UserDao> userDaoDb = userRepo.findByEmail(loginCred.getEmail());
		if(userDaoDb.isPresent()) {
			UserDao userDao = userDaoDb.get();
			if(userDao.getPassword().equals(loginCred.getPassword())) {
				return Optional.of(UserMapper.UserDaoToUser(userDao));
			}
		}
		return Optional.empty();
	}
	
	public Optional<User> getUserByEmail(String email) {
		Optional<UserDao> userDaoDb = userRepo.findByEmail(email);
		if(userDaoDb.isPresent()) {
			UserDao userDao = userDaoDb.get();
			return Optional.of(UserMapper.UserDaoToUser(userDao));
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
	
	public Optional<User> addUser(User user){
		Optional<UserDao> userDb = userRepo.findByEmail(user.getEmail());
		if(userDb.isEmpty()) {
			UserDao userDao = UserMapper.UserToUserDao(user);
			AddressDao userAdDao = UserMapper.AddressToAddressDao(user.getAddress());
			userAdDao.setId(user.getId());
			userDao.setAddress(userAdDao);
			userRepo.save(userDao);
			return Optional.of(UserMapper.UserDaoToUser(userDao));
		}
		return Optional.empty();
	}
	
	
	public Optional<User> updateUser(UUID id,User user){
		Optional<UserDao> userdb = userRepo.findById(id);
		if(userdb.isPresent()) {
			UserDao userDao = UserMapper.UserToUserDao(user);
			AddressDao userAdDao = new AddressDao();
			userAdDao = UserMapper.AddressToAddressDao(userAdDao,user.getAddress());
			UserDao userUpDao = new UserDao();
			userUpDao = userDao;
			userUpDao.setAddress(userAdDao);
			userRepo.save(userUpDao);
			return Optional.of(UserMapper.UserDaoToUser(userUpDao));
		}
		return Optional.empty();
	}

	public Optional<User> updateUserDetails(UUID id, User user){
		Optional<UserDao> userDaoDb = userRepo.findById(id);
		if(userDaoDb.isPresent()) {
			UserDao userDetails = UserMapper.UserToUserDao(userDaoDb.get(), user);
			userRepo.save(userDetails);
			return Optional.of(UserMapper.UserDaoToUser(userDetails));
		}
		return Optional.empty();
	}
	
	public Optional<User> updateUserAddress(UUID id,Address address) {
		Optional<UserDao> userDaoDb = userRepo.findById(id);
		if(userDaoDb.isPresent()) {
			UserDao userDb = userDaoDb.get();
			AddressDao addDao = userDaoDb.get().getAddress();
			userDb.setAddress(UserMapper.AddressToAddressDao(addDao, address));
			userRepo.save(userDb);
			return Optional.of(UserMapper.UserDaoToUser(userDb));
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


	


	


	

	
	
	
	
	
	
	
	
	
}
