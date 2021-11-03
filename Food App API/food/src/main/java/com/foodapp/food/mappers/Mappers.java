package com.foodapp.food.mappers;

import com.foodapp.food.daos.AddressDao;
import com.foodapp.food.daos.DeliveryPersonDao;
import com.foodapp.food.daos.DeliveryStatusDao;
import com.foodapp.food.daos.OrderStatusDao;
import com.foodapp.food.daos.PaymentDao;
import com.foodapp.food.daos.UserDao;
import com.foodapp.food.models.DeliveryPerson;
import com.foodapp.food.models.DeliveryStatus;
import com.foodapp.food.models.OrderStatus;
import com.foodapp.food.models.Payment;
import com.foodapp.food.models.UserOrder;

public class Mappers {
	
	public static PaymentDao PaymentToPaymentDao(Payment p) {
		PaymentDao p1 = new PaymentDao();
		p1.setId(p.getId());
		p1.setEmail(p.getEmail());
		p1.setAmount(p.getAmount());
		p1.setMode(p.getMode());
		p1.setOrderId(p.getOrderId());
		p1.setStatus(p.getStatus());
		return p1;
	}
	
	public static Payment PaymentDaoToPayment(PaymentDao p) {
		Payment p1 = new Payment();
		p1.setId(p.getId());
		p1.setEmail(p.getEmail());
		p1.setAmount(p.getAmount());
		p1.setMode(p.getMode());
		p1.setOrderId(p.getOrderId());
		p1.setStatus(p.getStatus());
		return p1;
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
		order.setId(orderStatusDao.getId());
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
