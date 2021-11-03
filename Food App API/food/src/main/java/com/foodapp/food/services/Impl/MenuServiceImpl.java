package com.foodapp.food.services.Impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.foodapp.food.daos.AdminDao;
import com.foodapp.food.daos.DishDao;
import com.foodapp.food.daos.MenuDao;
import com.foodapp.food.mappers.MenuMapper;
import com.foodapp.food.models.Dish;
import com.foodapp.food.models.Menu;
import com.foodapp.food.repositories.AdminRepo;
import com.foodapp.food.repositories.MenuRepo;
import com.foodapp.food.services.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private MenuRepo menuRepo;
	
	@Override
	public Optional<Menu> getMenu(String email) {
		Optional<MenuDao> menuDao = menuRepo.findByAdminEmail(email);
		if(menuDao.isPresent()) {
			return Optional.of(MenuMapper.MenuDaoToMenu(menuDao.get()));
		}
		return Optional.empty();
	}

	@Override
	public Optional<Dish> findDish(String menuName, String dishName) {
		Optional<MenuDao> menuDb = menuRepo.findByMenuCardName(menuName);
		if(menuDb.isPresent()) {
			menuRepo.delete(menuDb.get());
			List<DishDao> dishList = menuDb.get().getDishList();
			for(DishDao d : dishList) {
				if(dishName.equals(d.getName())) {
					return Optional.of(MenuMapper.DishDaoToDish(d));
				}
			}
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
			MenuDao menuDb = menuRepo.save(MenuMapper.MenuToMenuDao(menu));
			return Optional.of(MenuMapper.MenuDaoToMenu(menuDb));
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
			dishList.add(MenuMapper.DishToDishDao(dish));
			menuDb.get().setDishList(dishList);
			MenuDao menuDaoDb = menuRepo.save(menuDb.get());
			return Optional.of(MenuMapper.MenuDaoToMenu(menuDaoDb));
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
					DishDao dishUp = MenuMapper.UpdateDish(d,dish);
					dishList.remove(d);
					dishList.add(dishUp);
					break;
				}
			}
			menuDao.setDishList(dishList);
			menuRepo.delete(menuDb.get());
			menuRepo.save(menuDao);
			return Optional.of(MenuMapper.MenuDaoToMenu(menuDao));
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
			return Optional.of(MenuMapper.MenuDaoToMenu(menuDbDao));
		}
		return Optional.empty();
	}

	@Override
	public Optional<Menu> fetchMenuByRestaurant(String restaurantName) {
		Optional<MenuDao> menuDb = menuRepo.findByRestaurantName(restaurantName);
		if(menuDb.isPresent()) {
			return Optional.of(MenuMapper.MenuDaoToMenu(menuDb.get()));
		}
		return Optional.empty();
	}

}
