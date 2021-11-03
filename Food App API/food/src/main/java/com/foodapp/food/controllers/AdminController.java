package com.foodapp.food.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.foodapp.food.models.*;
import com.foodapp.food.services.AdminService;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	
	@GetMapping("/list")					
	public ResponseEntity<List<Admin>> allAdmin(){
		Optional<List<Admin>> admins = adminService.getList();
		if(admins.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(admins.get());
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Admin>  getById(@PathVariable("id") UUID id){
		Optional<Admin> adminDb = adminService.getById(id);
		if(adminDb.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(adminDb.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@PostMapping("")							
	public ResponseEntity<Admin> save(@RequestBody Admin admin){
		Optional<Admin> adminDb = null;
		if(admin!=null) {
			adminDb = adminService.registerAdmin(admin);
			if(adminDb.isEmpty()) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
			return ResponseEntity.status(HttpStatus.CREATED).body(adminDb.get());	
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@PostMapping("/update")								
	public ResponseEntity<Admin> update(@RequestBody Admin admin){
		Optional<Admin> adminDb = adminService.updateAdminDetail(admin);
		if(adminDb.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(adminDb.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Admin> remove(@PathVariable("id") UUID id){
		Optional<Admin> adminDb = adminService.delete(id);
		if(adminDb.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(adminDb.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
}
