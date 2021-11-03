package com.foodapp.food.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.foodapp.food.models.Address;

import com.foodapp.food.models.User;
import com.foodapp.food.services.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<User> addUser(@RequestBody User user){
		Optional<User> userdb=null;
		if(user!=null) {
			userdb = userService.addUser(user);
			if(userdb.isEmpty()) {
				return new ResponseEntity<User>(HttpStatus.CONFLICT);
			}
			return ResponseEntity.status(HttpStatus.CREATED).body(userdb.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();			
	}
	@GetMapping("/{id}")
	private ResponseEntity<Optional<User>> fetchUserById(@PathVariable("id") UUID id){
		Optional<User> userid = userService.getUserById(id);
		if(userid.isPresent()) {	
			return ResponseEntity.status(HttpStatus.OK).body(userid);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();	
	}
	@GetMapping("/list")
	public ResponseEntity<List<User>> getAllUser(){
		Optional<List<User>> userList = userService.getUserList();
		if(userList.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(userList.get());
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	@PutMapping("/update")
	private ResponseEntity<User> updateUser(@RequestBody User user){
		Optional<User> userdb = userService.updateUser(user.getId(),user);  
		if(userdb.isPresent()){
			return ResponseEntity.status(HttpStatus.OK).body(userdb.get());
		}
		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);			
	}
	@PatchMapping("/{id}")
	private ResponseEntity<User> updateUserDetails(@PathVariable("id") UUID id,@RequestBody User user){
		Optional<User> userDetail = userService.updateUserDetails(id, user);
		if(userDetail.isEmpty()) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.status(HttpStatus.OK).body(userDetail.get());
	}
	@PatchMapping("/{id}/address")
	private ResponseEntity<Address> updateAddressDetails(@PathVariable("id") UUID id, @RequestBody Address address){
		Optional<User> userDb = userService.updateUserAddress(id,address);
		if(userDb.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(userDb.get().getAddress());
		}
		return new ResponseEntity<Address>(HttpStatus.BAD_REQUEST);
	}
	@DeleteMapping("/{id}")
	private ResponseEntity<User> deleteUser(@PathVariable("id") UUID id){
		Optional<User> userStat = userService.deleteUser(id);
		if(userStat.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(userStat.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	
	
	
	
	
	
	
	
	
	
}
