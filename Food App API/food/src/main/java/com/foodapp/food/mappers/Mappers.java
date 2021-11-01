package com.foodapp.food.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.foodapp.food.daos.AddressDao;
import com.foodapp.food.daos.AdminDao;
import com.foodapp.food.daos.DeliveryPersonDao;
import com.foodapp.food.daos.DeliveryStatusDao;
import com.foodapp.food.daos.DishDao;
import com.foodapp.food.daos.MenuDao;
import com.foodapp.food.daos.OrderStatusDao;
import com.foodapp.food.daos.UserDao;
import com.foodapp.food.models.Address;
import com.foodapp.food.models.Admin;
import com.foodapp.food.models.DeliveryPerson;
import com.foodapp.food.models.DeliveryStatus;
import com.foodapp.food.models.Dish;
import com.foodapp.food.models.Menu;
import com.foodapp.food.models.OrderStatus;
import com.foodapp.food.models.User;
import com.foodapp.food.models.UserOrder;

public class Mappers {
	
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
	
	
	public static UserDao UserToUserDao(User user) {
		UserDao userDao = new UserDao();
		userDao.setId(user.getId());
		userDao.setName(user.getName());
		userDao.setEmail(user.getEmail());
		userDao.setPassword(user.getPassword());
		userDao.setPhnum(user.getPhnum());
		userDao.setCreated(user.getCreated());
		userDao.setUpdated(user.getUpdated());
		userDao.setAddress(Mappers.AddressToAddressDao(user.getAddress()));
		return userDao;
	}
	public static User UserDaoToUser(UserDao userDao) {
		User user = new User();
		user.setId(userDao.getId());
		user.setName(userDao.getName());
		user.setEmail(userDao.getEmail());
		user.setPhnum(userDao.getPhnum());
		user.setCreated(userDao.getCreated());
		user.setUpdated(userDao.getUpdated());
		user.setAddress(Mappers.AddressDaoToAddress(userDao.getAddress()));
		return user;
	}
	public static AddressDao AddressToAddressDao(Address address) {
		AddressDao addressDao = new AddressDao();
		addressDao.setId(address.getId());
		BeanUtils.copyProperties(address, addressDao);
		return addressDao;
	}
	public static Address AddressDaoToAddress(AddressDao addressDao) {
		Address address = new Address();
		address.setId(addressDao.getId());
		BeanUtils.copyProperties(addressDao, address);
		return address;
	}
	public static AddressDao AddressToAddressDao(AddressDao addressdao,Address address) {
		addressdao.setId(address.getId()!=null ? address.getId() : addressdao.getId());
		addressdao.setHno(address.getHno()!=null ? address.getHno() : addressdao.getHno());
		addressdao.setStreet(address.getStreet()!=null ? address.getStreet() : addressdao.getStreet());
		addressdao.setLandmark(address.getLandmark()!=null ? address.getLandmark() : addressdao.getLandmark());
		addressdao.setCity(address.getCity()!=null ? address.getCity() : addressdao.getCity());
		addressdao.setState(address.getState()!=null ? address.getState() : addressdao.getState());
		addressdao.setCountry(address.getCountry()!=null ? address.getCountry() : addressdao.getCountry());
		addressdao.setPincode(address.getPincode()!=0 ? address.getPincode() : addressdao.getPincode());
		addressdao.setCreated(address.getCreated()!=null ? address.getCreated() : addressdao.getCreated());
		addressdao.setUpdated(address.getUpdated()!=null ? address.getUpdated() : addressdao.getUpdated());
		return addressdao;	
	}
	public static UserDao UserToUserDao(UserDao userDetails,User user) {
		userDetails.setName(user.getName()!=null ? user.getName() : userDetails.getName());
		userDetails.setEmail(user.getEmail()!=null ? user.getEmail() : userDetails.getEmail());
		userDetails.setPhnum(user.getPhnum()!=null ? user.getPhnum() : userDetails.getPhnum());
		userDetails.setCreated(user.getCreated()!=null ? user.getCreated() : userDetails.getCreated());
		userDetails.setUpdated(user.getUpdated()!=null ? user.getUpdated() : userDetails.getUpdated());
		return userDetails;
	}
	
	public static MenuDao MenuToMenuDao(Menu menu) {
		MenuDao menuDao = new MenuDao();
		menuDao.setId(menu.getId());
		menuDao.setAdminEmail(menu.getAdminEmail());
		menuDao.setRestaurantName(menu.getRestaurantName());
		menuDao.setMenuCardName(menu.getMenuCardName());
		menuDao.setCreated(menu.getCreated());
		menuDao.setUpdated(menu.getUpdated());
		List<DishDao> dishDaoList = new ArrayList<>();
		for(Dish d : menu.getDishList()) {
			dishDaoList.add(Mappers.DishToDishDao(d));
		}
		menuDao.setDishList(dishDaoList);
		return menuDao;
	}
	
	public static Menu MenuDaoToMenu(MenuDao menuDao) {
		Menu menu = new Menu();
		menu.setId(menuDao.getId());
		menu.setAdminEmail(menuDao.getAdminEmail());
		menu.setRestaurantName(menuDao.getRestaurantName());
		menu.setMenuCardName(menuDao.getMenuCardName());
		menu.setCreated(menuDao.getCreated());
		menu.setUpdated(menuDao.getUpdated());
		List<Dish> dishList = new ArrayList<>();
		for(DishDao d : menuDao.getDishList()) {
			dishList.add(Mappers.DishDaoToDish(d));
		}
		menu.setDishList(dishList);
		return menu;
	}
	public static OrderStatusDao GetOrderDetailsDao(OrderStatusDao orderStatusDao, UserOrder order) {
		orderStatusDao.setEmail(order.getEmail());
		orderStatusDao.setRestaurantName(order.getRestaurantName());
		orderStatusDao.setDishName(order.getDishName());
		orderStatusDao.setQuantity(order.getQuantity());
		orderStatusDao.setPayment(order.getPayment());
		return orderStatusDao;
	}
	
	public static OrderStatus OrderStatusDaoToOrderStatus(OrderStatusDao orderStatusDao) {
		OrderStatus order = new OrderStatus();
		order.setEmail(orderStatusDao.getEmail());
		order.setRestaurantName(orderStatusDao.getRestaurantName());
		order.setDishName(orderStatusDao.getDishName());
		order.setQuantity(orderStatusDao.getQuantity());
		order.setAmount(orderStatusDao.getAmount());
		order.setPayment(orderStatusDao.getPayment());
		order.setStatus(orderStatusDao.getStatus());
		order.setCreated(orderStatusDao.getCreated());
		order.setUpdated(orderStatusDao.getUpdated());
		return order;
	}

	public static DishDao DishToDishDao(Dish dish) {
		DishDao dishDao = new DishDao();
		dishDao.setId(dish.getId());
		dishDao.setName(dish.getName());
		dishDao.setDesc(dish.getDesc());
		dishDao.setQuantity(dish.getQuantity());
		dishDao.setPrice(dish.getPrice());
		dishDao.setRating(dish.getRating());
		dishDao.setDishTime(dish.getDishTime());
		dishDao.setCreated(dish.getCreated());
		dishDao.setUpdated(dish.getUpdated());
		return dishDao;
	}
	
	public static Dish DishDaoToDish(DishDao dishDao) {
		Dish dish = new Dish();
		dish.setId(dishDao.getId());
		dish.setName(dishDao.getName());
		dish.setDesc(dishDao.getDesc());
		dish.setQuantity(dishDao.getQuantity());
		dish.setPrice(dishDao.getPrice());
		dish.setRating(dishDao.getRating());
		dish.setDishTime(dishDao.getDishTime());
		dish.setCreated(dishDao.getCreated());
		dish.setUpdated(dishDao.getUpdated());
		return dish;
	}

	public static DishDao UpdateDish(DishDao d, Dish dish) {
		d.setId(dish.getId()!=null ? dish.getId() : d.getId());
		d.setName(dish.getName()!=null ? dish.getName() : d.getName());
		d.setDesc(dish.getDesc()!=null ? dish.getDesc() : d.getDesc());
		d.setPrice(dish.getPrice()!=null ? dish.getPrice() : d.getPrice());
		d.setDishTime(dish.getDishTime()!=null ? dish.getDishTime() : d.getDishTime());
		d.setQuantity(dish.getQuantity()!=null ? dish.getQuantity() : d.getQuantity());
		d.setRating(dish.getRating()!=null ? dish.getRating() : d.getRating());
		d.setCreated(dish.getCreated()!=null ? dish.getCreated() : d.getCreated());
		return d;
	}

	
	
	public static DeliveryPerson DeliveryPersonDaoToDeliveryPerson(DeliveryPersonDao d2) {
		DeliveryPerson d1 = new DeliveryPerson();
		d1.setId(d2.getId());
		d1.setName(d2.getName());
		d1.setEmail(d2.getEmail());
		d1.setAvgTime(d2.getAvgTime());
		d1.setCurrentPincode(d2.getCurrentPincode());
		d1.setPhnum(d2.getPhnum());
		d1.setRating(d2.getRating());
		d1.setCreated(d2.getCreated());
		d1.setUpdated(d2.getUpdated());
		return d1;
	}

	public static DeliveryPersonDao DeliveryPersonToDeliveryPersonDao(DeliveryPerson d2) {
		DeliveryPersonDao d1 = new DeliveryPersonDao();
		d1.setId(d2.getId());
		d1.setName(d2.getName());
		d1.setEmail(d2.getEmail());
		d1.setAvgTime(d2.getAvgTime());
		d1.setCurrentPincode(d2.getCurrentPincode());
		d1.setPhnum(d2.getPhnum());
		d1.setRating(d2.getRating());
		d1.setCreated(d2.getCreated());
		d1.setUpdated(d2.getUpdated());
		return d1;
	}
	
	public static DeliveryStatus  DeliveryStatusDaoToDeliveryStatus(DeliveryStatusDao d) {
		DeliveryStatus d1 = new DeliveryStatus();
		d1.setDishName(d.getDishName());
		d1.setAddress(d.getAddress());
		d1.setAmmount(d.getAmmount());
		d1.setDeliveryPersonName(d.getDeliveryPersonName());
		d1.setDeliveryPersonRating(d.getDeliveryPersonRating());
		d1.setRestaurantName(d.getRestaurantName());
		d1.setDeliveryStatus(d.getDeliveryStatus());
		d1.setDishName(d.getDishName());
		d1.setEstTime(d.getAvgTime());
		d1.setCreated(d.getCreated());
		d1.setUpdated(d.getUpdated());
		return d1;
	}
	
	public static DeliveryStatusDao  DeliveryStatusToDeliveryStatusDao(DeliveryStatus d) {
		DeliveryStatusDao d1 = new DeliveryStatusDao();
		d1.setDishName(d.getDishName());
		d1.setAddress(d.getAddress());
		d1.setAmmount(d.getAmmount());
		d1.setDeliveryPersonName(d.getDeliveryPersonName());
		d1.setDeliveryPersonRating(d.getDeliveryPersonRating());
		d1.setRestaurantName(d1.getRestaurantName());
		d1.setDeliveryStatus(d.isDeliveryStatus());
		d1.setDishName(d.getDishName());
		d1.setAvgTime(d.getEstTime());
		d1.setCreated(d.getCreated());
		d1.setUpdated(d.getUpdated());
		return d1;
	}
	
	
	public static DeliveryStatusDao MapOrder(OrderStatusDao orderStatusDao,UserDao user,DeliveryPersonDao d){
		DeliveryStatusDao ds = new DeliveryStatusDao();
		ds.setRestaurantName(orderStatusDao.getRestaurantName());
		ds.setDishName(orderStatusDao.getDishName());
		ds.setAmmount(orderStatusDao.getAmount());
		ds.setAvgTime(d.getAvgTime());
		ds.setAddress(getAddress(user.getAddress()));
		ds.setDeliveryPersonName(d.getName());
		ds.setDeliveryPersonRating(d.getRating());
		ds.setDeliveryStatus(false);
		return ds;
		
	}
	
	public static String getAddress(AddressDao add) {
		return add.getHno() + " " + add.getStreet() +" " + add.getLandmark() + 
				" " + add.getCity()+" "+ add.getState() +" " + add.getCountry() + " " + add.getPincode();
	}
}
