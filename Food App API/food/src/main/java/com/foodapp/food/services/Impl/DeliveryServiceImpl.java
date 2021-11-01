package com.foodapp.food.services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.food.daos.DeliveryStatusDao;
import com.foodapp.food.mappers.Mappers;
import com.foodapp.food.models.DeliveryStatus;
import com.foodapp.food.repositories.DeliveryStatusRepo;
import com.foodapp.food.services.DeliveryService;

@Service
public class DeliveryServiceImpl implements DeliveryService {
	
	@Autowired
	private DeliveryStatusRepo delRepo;

	@Override
	public Optional<List<DeliveryStatus>> findOrders(String name) {
		Optional<List<DeliveryStatusDao>> order = delRepo.findByDeliveryPersonName(name);
		List<DeliveryStatus> orderDb =  new ArrayList<>();
		if(order.isPresent()) {
			for(DeliveryStatusDao d : order.get()) {
				orderDb.add(Mappers.DeliveryStatusDaoToDeliveryStatus(d));
			}
			return Optional.of(orderDb);
		}
		return Optional.empty();
	}

	@Override
	public Optional<DeliveryStatus> deliverOrder(DeliveryStatus delStat) {
		Optional<List<DeliveryStatusDao>> delDb = delRepo.findByDeliveryPersonName(delStat.getDeliveryPersonName());
		if(delDb.isPresent()) {
			for(DeliveryStatusDao d : delDb.get()) {
				if(d.getDishName().equals(delStat.getDishName())) {
					delRepo.delete(d);
					d.setDeliveryStatus(true);
					delRepo.save(d);
					return Optional.of(Mappers.DeliveryStatusDaoToDeliveryStatus(d));
				}
			}
		}
		return Optional.empty();
	}

}
