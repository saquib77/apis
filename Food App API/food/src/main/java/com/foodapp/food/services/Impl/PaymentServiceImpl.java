package com.foodapp.food.services.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.food.daos.PaymentDao;
import com.foodapp.food.mappers.Mappers;
import com.foodapp.food.models.Payment;
import com.foodapp.food.repositories.PaymentRepo;
import com.foodapp.food.services.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepo paymentRepo;

	@Override
	public Optional<Payment> getPaymentDetails(String email) {
		Optional<PaymentDao> paymentDb = paymentRepo.findByEmail(email);
		if(paymentDb.isPresent()) {
			return Optional.of(Mappers.PaymentDaoToPayment(paymentDb.get()));
		}
		return Optional.empty();
	}

	@Override
	public Optional<Payment> payOrder(Payment payment) {
		if(!payment.getStatus() && payment.getId()!=null) {
			PaymentDao paymentDao = paymentRepo.getById(payment.getId());
			if(paymentDao.getStatus()) {
				return Optional.empty();
			}
			paymentDao.setStatus(true);
			paymentDao = paymentRepo.save(paymentDao);
			return Optional.of(Mappers.PaymentDaoToPayment(paymentDao));
		}
		return Optional.empty();
	}
	
	
	
}
