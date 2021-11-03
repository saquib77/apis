package com.foodapp.food.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.foodapp.food.models.OrderStatus;
import com.foodapp.food.models.UserOrder;
import com.foodapp.food.services.OrderService;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("")
	public ResponseEntity<OrderStatus> placeOrder(@RequestBody UserOrder order){
		Optional<OrderStatus> orderDb = orderService.palceOrder(order);
		if(orderDb.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(orderDb.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<OrderStatus> getOrderById(@PathVariable("orderId") UUID orderId){
		Optional<OrderStatus> order = orderService.getOrder(orderId);
		if(order.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(order.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@GetMapping("/pending-order")
	public ResponseEntity<List<OrderStatus>> orderRequest(@RequestParam("restaurantName") String restaurantName){
		Optional<List<OrderStatus>> orderStatus = orderService.pendingOrders(restaurantName);
		if(orderStatus.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(orderStatus.get());
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PostMapping("/approve-request")
	private ResponseEntity<List<OrderStatus>> orderApproval(@RequestBody OrderStatus order){
		Optional<List<OrderStatus>> approvedRequest = orderService.approveOrder(order);
		if(approvedRequest.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(approvedRequest.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}
