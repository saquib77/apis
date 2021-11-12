package com.user.userapi.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.user.userapi.model.Address;
import com.user.userapi.model.LoginCred;
import com.user.userapi.model.User;
import com.user.userapi.services.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//GETTING ALL USERS
	
	@GetMapping("/list")
	private ResponseEntity<Optional<List<User>>> getAllUser(){
		Optional<List<User>> users = userService.getAllUser();
		if(users.get().isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();	
		}
		return ResponseEntity.status(HttpStatus.OK).body(users);	
	}
	
	//GETTING A SINGLE USER BY ID
	
	@GetMapping("/{id}")
	private ResponseEntity<Optional<User>> getUserByUUID(@PathVariable("id") UUID id){
		Optional<User> userid = userService.getUserById(id);
		if(userid.isPresent()) {	
			return ResponseEntity.status(HttpStatus.OK).body(userid);		
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();		
	}
	
	@GetMapping("/email")
	private ResponseEntity<Optional<User>> getUserByEmail(@RequestParam String email){
		Optional<User> userid = userService.getUserByEmail(email);
		if(userid.isEmpty()) {	
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();		
		}
		return ResponseEntity.status(HttpStatus.OK).body(userid);			
	}
	
	@GetMapping("/login")
	private ResponseEntity<User> userLogin(@Validated @RequestBody LoginCred loginCred){
		Optional<User> userFound = userService.loginUserByEmailAndPass(loginCred);
		if(userFound.get()!=null) {	
			return ResponseEntity.status(HttpStatus.OK).body(userFound.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	//ADDING A USER
	
	
	@PostMapping("/register")
	private ResponseEntity<User> registerUser(@RequestBody User user){
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
	
	//UPDATING USER DETAILS   
	
	
	@PutMapping("/update")
	private ResponseEntity<User> updateUser(@RequestBody User user){
		Optional<User> userdb = userService.updateUser(user.getId(),user);  
		if(userdb.isPresent()){
			return ResponseEntity.status(HttpStatus.OK).body(userdb.get());			
		}
		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);			
	}
	
	//PATCHING DATA
	
	@PatchMapping("/{id}")
	private ResponseEntity<User> updateUserDetails(@PathVariable("id") UUID id,@RequestBody User user){
		Optional<User> userDetail = userService.updateUserDetails(id, user);								//updating user details
		if(userDetail.isEmpty()) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.status(HttpStatus.OK).body(userDetail.get());
	}
	
	
	@PatchMapping("/{id}/address")
	private ResponseEntity<Address> updateAddressDetails(@PathVariable("id") UUID id, @RequestBody Address address){
		Optional<User> userDb = userService.updateUserAddress(id,address);
		if(userDb.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(userDb.get().getAddress());			//updating user address
		}
		return new ResponseEntity<Address>(HttpStatus.BAD_REQUEST);
	}
	
	//DELETING USER BY ID
	
	
	@DeleteMapping("/{id}")
	private ResponseEntity<User> deleteUser(@PathVariable("id") UUID id){
		Optional<User> userStat = userService.deleteUser(id);
		if(userStat.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(userStat.get());			
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	
	
	
	
	
}
