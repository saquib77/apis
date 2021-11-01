package com.foodapp.food.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.foodapp.food.models.*;
import com.foodapp.food.services.AdminService;

@RestController
@RequestMapping("/api/v1/foodapp/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	
	//----------------------------Admin-----------------------
	
	@GetMapping("/list")										// List Of Admins
	public ResponseEntity<List<Admin>> getAllAdmin(){
		Optional<List<Admin>> admins = adminService.getList();
		if(admins.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(admins.get());
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	@PostMapping("/register")								// Register Admin
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin){
		Optional<Admin> adminDb = adminService.registerAdmin(admin);
		if(adminDb.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(adminDb.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@PostMapping("/update")									// Update Admin Details
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin){
		Optional<Admin> adminDb = adminService.updateAdminDetail(admin);
		if(adminDb.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(adminDb.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	//----------------------------Menu -------------------------
	
	@GetMapping("/menu")										// Get Menu
	public ResponseEntity<Menu> getMenu(@RequestParam("email") String email){
		Optional<Menu> menuDb = adminService.getMenu(email);
		if(menuDb.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(menuDb.get());
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PostMapping("/menu")										// Add Menu
	public ResponseEntity<Menu> addMenu(@RequestBody Menu menu){
		Optional<Menu> menuDb = adminService.saveMenu(menu);
		if(menuDb.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(menuDb.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@PostMapping("/menu/dish")										// Add Dish in Menu
	public ResponseEntity<Menu> addDish(@RequestParam("menu_name") String menuName,@RequestBody Dish dish){
		Optional<Menu> dishDb = adminService.addDish(menuName,dish);
		if(dishDb.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(dishDb.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
	}
	
	@PutMapping("/menu/dish")									// Update Dish
	public ResponseEntity<Menu> updateDish(@RequestParam("menu_name") String menuName,@RequestBody Dish dish){
		Optional<Menu> dishDb = adminService.updateDish(menuName,dish);
		if(dishDb.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(dishDb.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@DeleteMapping("/menu/dish")									// Delete Dish
	public ResponseEntity<Menu> deleteDish(@RequestParam("menuName") String menuName,@RequestParam("dishName")String dishName){
		Optional<Menu> dishDb = adminService.deleteDish(menuName,dishName);
		if(dishDb.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(dishDb.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	//------------------------Orders------------------------------------------
	
	
	@GetMapping("/pendingRequest")
	public ResponseEntity<List<OrderStatus>> getAllOrders(@RequestParam("restaurantName") String restaurantName){
		Optional<List<OrderStatus>> orderStatus = adminService.pendingOrders(restaurantName);
		if(orderStatus.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(orderStatus.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@PostMapping("/approveRequest")
	private ResponseEntity<List<OrderStatus>> approveOrderRequest(@RequestParam("restaurantName") String restaurantName){
		Optional<List<OrderStatus>> approvedRequest = adminService.approveOrder(restaurantName);
		if(approvedRequest.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(approvedRequest.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	
	@PostMapping("/register/delPerson")
	public ResponseEntity<DeliveryPerson> registerDeliveryPerson(@RequestBody DeliveryPerson delPer){
		Optional<DeliveryPerson> delPerson = adminService.addDeliveryPerson(delPer);
		if(delPerson.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(delPerson.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	
	
	
	
	
}
