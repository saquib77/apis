package com.foodapp.food.services.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foodapp.food.daos.AdminDao;
import com.foodapp.food.daos.DeliveryPersonDao;
import com.foodapp.food.daos.DeliveryStatusDao;
import com.foodapp.food.daos.DishDao;
import com.foodapp.food.daos.MenuDao;
import com.foodapp.food.daos.OrderStatusDao;
import com.foodapp.food.daos.UserDao;
import com.foodapp.food.mappers.Mappers;
import com.foodapp.food.models.*;
import com.foodapp.food.repositories.AdminRepo;
import com.foodapp.food.repositories.DeliveryPersonRepo;
import com.foodapp.food.repositories.DeliveryStatusRepo;
import com.foodapp.food.repositories.MenuRepo;
import com.foodapp.food.repositories.OrderStatusRepo;
import com.foodapp.food.repositories.UserRepo;
import com.foodapp.food.services.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private OrderStatusRepo orderRepo;
	
	@Autowired
	private MenuRepo menuRepo;
	
	@Autowired
	private DeliveryPersonRepo delRepo;
	
	@Autowired
	private DeliveryStatusRepo delStatRepo;
	
	@Autowired
	private UserRepo uRepo;

	@Override
	public Optional<Admin> registerAdmin(Admin admin) {
		Optional<AdminDao> adminDao = adminRepo.findAdminByEmail(admin.getEmail());
		if(adminDao.isEmpty()) {
			admin.setCreated(new Date());
			admin.setUpdated(new Date());
			AdminDao adminDaoNew = adminRepo.save(Mappers.AdminToAdminDao(admin));
			return Optional.of(Mappers.AdminDaoToAdmin(adminDaoNew));
		}
		return Optional.empty();
	}

	@Override
	public Optional<Admin> updateAdminDetail(Admin admin) {
		Optional<AdminDao> adminDaoDb = adminRepo.findAdminByEmail(admin.getEmail());
		if(adminDaoDb.isPresent()) {
			AdminDao adminDaoUp = Mappers.AdminUpdater(adminDaoDb.get(),admin);
			adminDaoUp.setUpdated(new Date());
			adminRepo.save(adminDaoUp);
			return Optional.of(Mappers.AdminDaoToAdmin(adminDaoUp));
		}
		return Optional.empty();
	}

	@Override
	public Optional<Menu> saveMenu(Menu menu) {
		Optional<AdminDao> adminDaoDb = adminRepo.findAdminByEmail(menu.getAdminEmail());
		if(!adminDaoDb.isEmpty()) {
			menu.setCreated(new Date());
			menu.setUpdated(new Date());
			List<Dish> dishList = menu.getDishList();
			for(Dish d : dishList) {
				d.setCreated(new Date());
				d.setUpdated(new Date());
			}
			menu.setDishList(dishList);
			MenuDao menuDb = menuRepo.save(Mappers.MenuToMenuDao(menu));
			return Optional.of(Mappers.MenuDaoToMenu(menuDb));
		}
		return Optional.empty();
	}

	@Override
	public Optional<Menu> getMenu(String email) {
		Optional<MenuDao> menuDao = menuRepo.findByAdminEmail(email);
		if(menuDao.isPresent()) {
			return Optional.of(Mappers.MenuDaoToMenu(menuDao.get()));
		}
		return Optional.empty();
	}

	@Override
	public Optional<List<Admin>> getList() {
		List<AdminDao> adminListDb = adminRepo.findAll();
		List<Admin> adminList = new ArrayList<>();
		if(!adminListDb.isEmpty()) {
			for(AdminDao d : adminListDb) {
				adminList.add(Mappers.AdminDaoToAdmin(d));
			}
			return Optional.of(adminList);
		}
		return Optional.empty();
		
	}

	@Override
	public Optional<Menu> addDish(String menuName,Dish dish) {
		Optional<MenuDao> menuDb = menuRepo.findByMenuCardName(menuName);
		if(menuDb.isPresent()) {
			List<DishDao> dishList = menuDb.get().getDishList();
			dish.setCreated(new Date());
			dish.setUpdated(new Date());
			dishList.add(Mappers.DishToDishDao(dish));
			menuDb.get().setDishList(dishList);
			MenuDao menuDaoDb = menuRepo.save(menuDb.get());
			return Optional.of(Mappers.MenuDaoToMenu(menuDaoDb));
		}
		return Optional.empty();
	}

	@Override
	public Optional<Menu> deleteDish(String menuName, String dishName) {
		Optional<MenuDao> menuDb = menuRepo.findByMenuCardName(menuName);
		if(menuDb.isPresent()) {
			menuRepo.delete(menuDb.get());
			List<DishDao> dishList = menuDb.get().getDishList();
			for(DishDao d : dishList) {
				if(dishName.equals(d.getName())) {
					dishList.remove(d);
					break;
				}
			}
			MenuDao menuDbDao = menuDb.get();
			menuDbDao.setDishList(dishList);
			menuRepo.save(menuDbDao);
			return Optional.of(Mappers.MenuDaoToMenu(menuDbDao));
		}
		return Optional.empty();
	}

	@Override
	public Optional<Menu> updateDish(String menuName, Dish dish) {
		Optional<MenuDao> menuDb = menuRepo.findByMenuCardName(menuName);
		if(menuDb.isPresent()) {
			MenuDao menuDao = menuDb.get();
			List<DishDao> dishList = menuDao.getDishList();
			for(DishDao d : dishList) {
				if(dish.getName().equals(d.getName())) {
					d.setUpdated(new Date());
					DishDao dishUp = Mappers.UpdateDish(d,dish);
					dishList.remove(d);
					dishList.add(dishUp);
					break;
				}
			}
			menuDao.setDishList(dishList);
			menuRepo.delete(menuDb.get());
			menuRepo.save(menuDao);
			return Optional.of(Mappers.MenuDaoToMenu(menuDao));
		}
		return Optional.empty();
	}
	
	@Override
	public Optional<DeliveryPerson> addDeliveryPerson(DeliveryPerson delPer) {
		Optional<DeliveryPersonDao> delDb = delRepo.findByEmail(delPer.getEmail());
		if(delDb.isEmpty()) {
			DeliveryPersonDao delPerDb = Mappers.DeliveryPersonToDeliveryPersonDao(delPer);
			delPerDb.setCreated(new Date());
			delPerDb.setUpdated(new Date());
			return Optional.of(Mappers.DeliveryPersonDaoToDeliveryPerson(delRepo.save(delPerDb)));
		}
		return Optional.empty();
	}

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
	public Optional<List<OrderStatus>> approveOrder(String restaurantName) {
		List<OrderStatusDao> listOrder = orderRepo.findByRestaurantName(restaurantName);
		if(!listOrder.isEmpty()) {
			List<OrderStatus> list = new ArrayList<>();
			for(OrderStatusDao d : listOrder) {
				if(d.getPayment()) {
					orderRepo.delete(d);
					d.setStatus(true);
					d.setUpdated(new Date());
					orderRepo.save(d);
					DeliverOrder(d);
					list.add(Mappers.OrderStatusDaoToOrderStatus(d));
				}
			}
			return Optional.of(list);
		}
		return Optional.empty();
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
