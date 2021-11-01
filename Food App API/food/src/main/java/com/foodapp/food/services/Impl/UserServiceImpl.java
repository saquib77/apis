package com.foodapp.food.services.Impl;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.food.daos.AddressDao;
import com.foodapp.food.daos.DishDao;
import com.foodapp.food.daos.MenuDao;
import com.foodapp.food.daos.OrderStatusDao;
import com.foodapp.food.daos.UserDao;
import com.foodapp.food.mappers.Mappers;
import com.foodapp.food.models.Address;
import com.foodapp.food.models.Menu;
import com.foodapp.food.models.OrderStatus;
import com.foodapp.food.models.User;
import com.foodapp.food.models.UserOrder;
import com.foodapp.food.repositories.MenuRepo;
import com.foodapp.food.repositories.OrderStatusRepo;
import com.foodapp.food.repositories.UserRepo;
import com.foodapp.food.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private MenuRepo menuRepo;

	@Autowired
	private OrderStatusRepo orderRepo;
	
	@Override
	public Optional<User> addUser(User user) {
		Optional<UserDao> userDaoDb = userRepo.findByEmail(user.getEmail());
		if(userDaoDb.isEmpty()) {
			UserDao userDao =  userRepo.save(Mappers.UserToUserDao(user));
			return Optional.of(Mappers.UserDaoToUser(userDao));
		}
		return Optional.empty();
	}

	@Override
	public Optional<List<User>> getUserList() {
		List<UserDao> userDaoDb = userRepo.findAll();
		if(!userDaoDb.isEmpty()) {
			List<User> userList = new ArrayList<>();
			for(UserDao d : userDaoDb) {
				userList.add(Mappers.UserDaoToUser(d));
			}
			return Optional.of(userList);
		}
		return Optional.empty();
	}
	
	public Optional<User> getUserById(UUID id){
		Optional<UserDao> user = userRepo.findById(id);
		if(user.isPresent()){
			User userdb = Mappers.UserDaoToUser(user.get());
			return Optional.of(userdb);
		}
		return Optional.empty();
	}

	public Optional<User> updateUser(UUID id,User user){
		Optional<UserDao> userdb = userRepo.findById(id);
		if(userdb.isPresent()) {
			UserDao userDao = Mappers.UserToUserDao(user);
			AddressDao userAdDao = new AddressDao();
			userAdDao = Mappers.AddressToAddressDao(userAdDao,user.getAddress());
			UserDao userUpDao = new UserDao();
			userUpDao = userDao;
			userUpDao.setAddress(userAdDao);
			userRepo.save(userUpDao);
			return Optional.of(Mappers.UserDaoToUser(userUpDao));
		}
		return Optional.empty();
	}
	public Optional<User> deleteUser(UUID id) {
		Optional<UserDao> userdb = userRepo.findById(id);
		if(userdb.isPresent()) {
			UserDao userDbDao = userdb.get();
			userRepo.delete(userDbDao);
			return Optional.of(Mappers.UserDaoToUser(userDbDao));
		}
		return Optional.empty();
	}
	public Optional<User> updateUserAddress(UUID id,Address address) {
		Optional<UserDao> userDaoDb = userRepo.findById(id);
		if(userDaoDb.isPresent()) {
			UserDao userDb = userDaoDb.get();
			AddressDao addDao = userDaoDb.get().getAddress();
			userDb.setAddress(Mappers.AddressToAddressDao(addDao, address));
			userRepo.save(userDb);
			return Optional.of(Mappers.UserDaoToUser(userDb));
		}
		return Optional.empty();
	}
	
	public Optional<User> updateUserDetails(UUID id, User user){
		Optional<UserDao> userDaoDb = userRepo.findById(id);
		if(userDaoDb.isPresent()) {
			UserDao userDetails = Mappers.UserToUserDao(userDaoDb.get(), user);
			userRepo.save(userDetails);
			return Optional.of(Mappers.UserDaoToUser(userDetails));
		}
		return Optional.empty();
	}

	@Override
	public Optional<Menu> fetchMenuByRestaurant(String restaurantName) {
		Optional<MenuDao> menuDb = menuRepo.findByRestaurantName(restaurantName);
		System.out.println(menuDb.get());
		if(menuDb.isPresent()) {
			return Optional.of(Mappers.MenuDaoToMenu(menuDb.get()));
		}
		return Optional.empty();
	}

	@Override
	public Optional<OrderStatus> palceOrder(UserOrder order) {
		Optional<MenuDao> menuDb = menuRepo.findByRestaurantName(order.getRestaurantName());
		if(menuDb.isPresent()) {
			List<DishDao> listDish = menuDb.get().getDishList();
			OrderStatusDao orderStatus = new OrderStatusDao();
			for(DishDao d : listDish) {
				if(d.getName().equals(order.getDishName())){
					orderStatus.setAmount(order.getQuantity() * Double.parseDouble(d.getPrice()));
				}
			}
			OrderStatusDao orderDetail = Mappers.GetOrderDetailsDao(orderStatus,order);
			if(orderDetail!=null) {
				return Optional.of(Mappers.OrderStatusDaoToOrderStatus(orderRepo.save(orderDetail)));
			}
		}
		
		return Optional.empty();
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
