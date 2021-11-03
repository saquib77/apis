package com.foodapp.food.controllers;

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

import com.foodapp.food.models.Payment;
import com.foodapp.food.services.PaymentService;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/{email}")
	public ResponseEntity<Payment> getPaymentDetails(@PathVariable("email") String email){
		Optional<Payment> payment = paymentService.getPaymentDetails(email);
		if(payment.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(payment.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@PostMapping("")
	public ResponseEntity<Payment> orderPayment(@RequestBody Payment payment){
		//System.out.println(payment);
		Optional<Payment> paid = null;
		if(payment!=null) {
			paid = paymentService.payOrder(payment);
			if(paid.isPresent()) {
				return ResponseEntity.status(HttpStatus.OK).body(paid.get());
			}
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}
