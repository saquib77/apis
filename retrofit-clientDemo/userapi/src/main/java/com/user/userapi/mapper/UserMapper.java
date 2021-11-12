package com.user.userapi.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.user.userapi.dao.AddressDao;
import com.user.userapi.dao.UserDao;
import com.user.userapi.model.Address;
import com.user.userapi.model.User;


public class UserMapper {
	public static User UserDaoToUser(UserDao userdao) {
		User user = new User();
		user.setId(userdao.getId());
		user.setFirstname(userdao.getFirstname());
		user.setLastname(userdao.getLastname());
		user.setEmail(userdao.getEmail());
		user.setDob(userdao.getDob());
		user.setCreated(userdao.getCreated());
		user.setUpdated(userdao.getUpdated());
		user.setAddress(UserMapper.AddressDaoToAddress(userdao.getAddress()));
		return user;
	}

	
	public static AddressDao AddressToAddressDao(Address address) {
		AddressDao addressDao = new AddressDao();
		BeanUtils.copyProperties(address, addressDao);
		return addressDao;
	}
	
	public static AddressDao AddressToAddressDao(AddressDao addressdao,Address address) {
		addressdao.setId(address.getId()!=null ? address.getId() : addressdao.getId());
		addressdao.setHno(address.getHno()!=0 ? address.getHno() : addressdao.getHno());
		addressdao.setStreet(address.getStreet()!=null ? address.getStreet() : addressdao.getStreet());
		addressdao.setCity(address.getCity()!=null ? address.getCity() : addressdao.getCity());
		addressdao.setState(address.getState()!=null ? address.getState() : addressdao.getState());
		addressdao.setCountry(address.getCountry()!=null ? address.getCountry() : addressdao.getCountry());
		addressdao.setPincode(address.getPincode()!=0 ? address.getPincode() : addressdao.getPincode());
		addressdao.setCreated(address.getCreated()!=null ? address.getCreated() : addressdao.getCreated());
		addressdao.setUpdated(address.getUpdated()!=null ? address.getUpdated() : addressdao.getUpdated());
		return addressdao;	
	}	

	public static UserDao UserToUserDao(UserDao userDetails,User user) {
		userDetails.setFirstname( user.getFirstname()!=null ? user.getFirstname() : userDetails.getFirstname() );
		userDetails.setLastname(user.getLastname()!=null ? user.getLastname() : userDetails.getLastname());
		userDetails.setEmail( user.getEmail()!=null ? user.getEmail() : userDetails.getEmail() );
		userDetails.setDob( user.getDob()!=null ? user.getDob() : userDetails.getDob() );
		return userDetails;
	}
	
	public static Address AddressDaoToAddress(AddressDao addressdao) {
		Address address = new Address();
		address.setId(addressdao.getId());
		address.setHno(addressdao.getHno());
		address.setStreet(addressdao.getStreet());
		address.setCity(addressdao.getCity());
		address.setState(addressdao.getState());
		address.setCountry(addressdao.getCountry());
		address.setPincode(addressdao.getPincode());
		address.setCreated(addressdao.getCreated());
		address.setUpdated(addressdao.getUpdated());
		return address;	
	}
	public static UserDao UserToUserDao(User user) {
		UserDao userdao = new UserDao();
		userdao.setId(user.getId());
		userdao.setFirstname(user.getFirstname());
		userdao.setLastname(user.getLastname());
		userdao.setEmail(user.getEmail());
		userdao.setDob(user.getDob());
		userdao.setPassword(user.getPassword());
		userdao.setAddress(UserMapper.AddressToAddressDao(user.getAddress()));
		return  userdao;
	}
	
	public static List<User> UserdbListtoUserList(List<UserDao> list){
		return list.stream().map(x -> UserDaoToUser(x)).collect(Collectors.toList());
	}
}
