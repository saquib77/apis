package com.foodapp.food.services.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.food.daos.DeliveryPersonDao;
import com.foodapp.food.daos.DeliveryStatusDao;
import com.foodapp.food.daos.DishDao;
import com.foodapp.food.daos.MenuDao;
import com.foodapp.food.daos.OrderStatusDao;
import com.foodapp.food.daos.PaymentDao;
import com.foodapp.food.daos.UserDao;
import com.foodapp.food.mappers.Mappers;
import com.foodapp.food.models.OrderStatus;
import com.foodapp.food.models.UserOrder;
import com.foodapp.food.repositories.DeliveryPersonRepo;
import com.foodapp.food.repositories.DeliveryStatusRepo;
import com.foodapp.food.repositories.MenuRepo;
import com.foodapp.food.repositories.OrderStatusRepo;
import com.foodapp.food.repositories.PaymentRepo;
import com.foodapp.food.repositories.UserRepo;
import com.foodapp.food.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private UserRepo uRepo;
	
	@Autowired
	private OrderStatusRepo orderRepo;
	
	@Autowired
	private MenuRepo menuRepo;

	@Autowired
	private DeliveryStatusRepo delStatRepo;

	@Autowired
	private DeliveryPersonRepo delRepo;
	
	@Autowired
	private PaymentRepo paymentRepo;
	
	@Override
	public Optional<List<OrderStatus>> pendingOrders(String restaurantName) {
		List<OrderStatusDao> listOrder = orderRepo.findByRestaurantName(restaurantName);
		if(!listOrder.isEmpty()) {
			List<OrderStatus> res = new ArrayList<>();
			for(OrderStatusDao d : listOrder) {
				if(d.getPayment()==true && d.getStatus()==false) {
					res.add(Mappers.OrderStatusDaoToOrderStatus(d));
				}
			}
			return Optional.of(res);
		}
		return Optional.empty();
	}
	
	@Override
	public Optional<OrderStatus> palceOrder(UserOrder order) {
		Optional<MenuDao> menuDb = menuRepo.findByRestaurantName(order.getRestaurantName());
		if(menuDb.isPresent()) {
			List<DishDao> listDish = menuDb.get().getDishList();
			OrderStatusDao orderStatus = new OrderStatusDao();
			orderStatus.setCreated(new Date());
			orderStatus.setUpdated(new Date());
			boolean flag=false;
			for(DishDao d : listDish) {
				if(d.getName().equals(order.getDishName())){
					orderStatus.setAmount(order.getQuantity() * Double.parseDouble(d.getPrice()));
					flag=true;
				}
			}
			if(flag==false) {
				return Optional.empty();
			}
			orderStatus = Mappers.GetOrderDetailsDao(orderStatus,order);
			if(orderStatus!=null) {
				OrderStatusDao orderStat = orderRepo.save(orderStatus);
				SavePayment(orderStat);
				return Optional.of(Mappers.OrderStatusDaoToOrderStatus(orderStat));
			}
		}
		
		return Optional.empty();
	}
	
	@Override
	public Optional<OrderStatus> getOrder(UUID id) {
		Optional<OrderStatusDao> orderDb = orderRepo.findById(id);
		if(orderDb.isPresent()) {
			return Optional.of(Mappers.OrderStatusDaoToOrderStatus(orderDb.get()));
		}
		return Optional.empty();
	}
	
	@Override
	public Optional<List<OrderStatus>> approveOrder(OrderStatus order) {
		List<PaymentDao> paymentDb = paymentRepo.getPaymentByRestaurantName(order.getRestaurantName());
		if(!paymentDb.isEmpty()) {
			List<OrderStatusDao> listOrder = orderRepo.findByRestaurantName(order.getRestaurantName());
			if(!listOrder.isEmpty()) {
				List<OrderStatus> list = new ArrayList<>();
				for(PaymentDao p : paymentDb) {
					for(OrderStatusDao d : listOrder) {
						if(p.getOrderId().equals(d.getId())) {
							orderRepo.delete(d);
							d.setStatus(true);
							d.setUpdated(new Date());
							orderRepo.save(d);
							DeliverOrder(d);
							list.add(Mappers.OrderStatusDaoToOrderStatus(d));
						}
					}
				}
				return Optional.of(list);
			}
		}
		return Optional.empty();
	}

	public void SavePayment(OrderStatusDao order) {
		PaymentDao pay = new PaymentDao();
		pay.setOrderId(order.getId());
		pay.setAmount(order.getAmount());
		pay.setEmail(order.getEmail());
		pay.setRestaurantName(order.getRestaurantName());
		pay.setStatus(false);
		paymentRepo.save(pay);
	}
	
	public void DeliverOrder(OrderStatusDao orderStatusDao) {
		Optional<UserDao> user = uRepo.findByEmail(orderStatusDao.getEmail());
		List<DeliveryPersonDao> delPer = delRepo.findAll();
		for(DeliveryPersonDao d : delPer) {
			if(d.getCurrentPincode()==user.get().getAddress().getPincode()) {
				DeliveryStatusDao ds = Mappers.MapOrder(orderStatusDao, user.get(), d);
				ds.setCreated(new Date());
				ds.setUpdated(new Date());
				delStatRepo.save(ds);
			}
		}
	}
}
