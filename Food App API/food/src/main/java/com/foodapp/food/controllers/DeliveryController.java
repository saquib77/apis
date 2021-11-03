package com.foodapp.food.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.food.models.DeliveryPerson;
import com.foodapp.food.models.DeliveryStatus;
import com.foodapp.food.services.DeliveryService;

@RestController
@RequestMapping("/api/v1/delivery")
public class DeliveryController {

	@Autowired
	private DeliveryService delService; 
	
	@PostMapping("/register")
	public ResponseEntity<DeliveryPerson> registerDeliveryPerson(@RequestBody DeliveryPerson delPer){
		Optional<DeliveryPerson> delPerson = delService.addDeliveryPerson(delPer);
		if(delPerson.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(delPerson.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	
	@GetMapping("/{name}")
	public ResponseEntity<List<DeliveryStatus>> getAllOrdersAssigned(@PathVariable("name")String name){
		Optional<List<DeliveryStatus>> delOrder = delService.findOrders(name);
		if(delOrder.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(delOrder.get());
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PostMapping("")
	public ResponseEntity<DeliveryStatus> deliverOrder(@RequestBody DeliveryStatus delStat){
		Optional<DeliveryStatus> deliveryStatDb = delService.deliverOrder(delStat); 
		if(deliveryStatDb.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(deliveryStatDb.get());
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
}
