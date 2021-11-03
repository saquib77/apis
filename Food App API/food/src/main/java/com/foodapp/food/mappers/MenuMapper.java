package com.foodapp.food.mappers;

import java.util.ArrayList;
import java.util.List;

import com.foodapp.food.daos.DishDao;
import com.foodapp.food.daos.MenuDao;
import com.foodapp.food.models.Dish;
import com.foodapp.food.models.Menu;

public class MenuMapper {
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
			dishDaoList.add(MenuMapper.DishToDishDao(d));
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
			dishList.add(MenuMapper.DishDaoToDish(d));
		}
		menu.setDishList(dishList);
		return menu;
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

}
