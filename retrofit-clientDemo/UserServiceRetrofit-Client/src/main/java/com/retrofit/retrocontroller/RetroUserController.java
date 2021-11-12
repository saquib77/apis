package com.retrofit.retrocontroller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retrofit.client.UserServiceClient;
import com.retrofit.model.UserResponse;

@RestController
@RequestMapping("/user")
public class RetroUserController {
	
	@Autowired
	private UserServiceClient userService;
	
	@GetMapping("/list")
	private ResponseEntity<List<UserResponse>> getAllUser(){
		List<UserResponse> list = userService.getAllUser();
		if(list!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<UserResponse> getUser(@PathVariable("id") UUID id){
		UserResponse user = userService.getUser(id);
		if(user!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(user);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	
}
