package com.foodapp.food.mappers;

import org.springframework.beans.BeanUtils;

import com.foodapp.food.daos.AddressDao;
import com.foodapp.food.daos.UserDao;
import com.foodapp.food.models.Address;
import com.foodapp.food.models.User;

public class UserMapper {
	public static UserDao UserToUserDao(User user) {
		UserDao userDao = new UserDao();
		userDao.setId(user.getId());
		userDao.setName(user.getName());
		userDao.setEmail(user.getEmail());
		userDao.setPassword(user.getPassword());
		userDao.setPhnum(user.getPhnum());
		userDao.setCreated(user.getCreated());
		userDao.setUpdated(user.getUpdated());
		userDao.setAddress(UserMapper.AddressToAddressDao(user.getAddress()));
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
		user.setAddress(UserMapper.AddressDaoToAddress(userDao.getAddress()));
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
	
}
