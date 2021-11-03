package com.foodapp.food.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.food.models.Dish;
import com.foodapp.food.models.Menu;
import com.foodapp.food.services.MenuService;

@RestController
@RequestMapping("/api/v1/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@GetMapping("/{email}")								
	public ResponseEntity<Menu> getMenu(@PathVariable("email") String email){
		Optional<Menu> menuDb = menuService.getMenu(email);
		if(menuDb.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(menuDb.get());
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	@GetMapping("")
	public ResponseEntity<Menu> getRestaurantMenu(@RequestParam("restaurantName") String restaurantName){
		Optional<Menu> menuDb = menuService.fetchMenuByRestaurant(restaurantName);
		if(menuDb.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(menuDb.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	@GetMapping("")
	public ResponseEntity<Dish> getDish(@RequestParam List<String> data){
		Optional<Dish> dishDb = menuService.findDish(data.get(0),data.get(1));
		if(dishDb.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(dishDb.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@PostMapping("")			
	public ResponseEntity<Menu> addMenu(@RequestBody Menu menu){
		Optional<Menu> menuDb = menuService.saveMenu(menu);
		if(menuDb.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(menuDb.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@PostMapping("/{menu_name}/dish")					
	public ResponseEntity<Menu> addDish(@PathVariable("menu_name") String menuName,@RequestBody Dish dish){
		Optional<Menu> dishDb = menuService.addDish(menuName,dish);
		if(dishDb.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(dishDb.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
	}
	
	@PutMapping("/{menu_name}/dish")					
	public ResponseEntity<Menu> updateDish(@PathVariable("menuname") String menuName,@RequestBody Dish dish){
		Optional<Menu> dishDb = menuService.updateDish(menuName,dish);
		if(dishDb.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(dishDb.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@DeleteMapping("")					
	public ResponseEntity<Menu> deleteDish(@RequestParam List<String> data){
		Optional<Menu> dishDb = menuService.deleteDish(data.get(0),data.get(1));
		if(dishDb.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(dishDb.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
}
