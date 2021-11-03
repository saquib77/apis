package com.foodapp.food.services;

import java.util.Optional;

import com.foodapp.food.models.Payment;

public interface PaymentService {

	Optional<Payment> getPaymentDetails(String email);

	Optional<Payment> payOrder(Payment payment);

}
