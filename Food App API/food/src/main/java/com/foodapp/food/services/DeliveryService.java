package com.foodapp.food.services;

import java.util.List;
import java.util.Optional;

import com.foodapp.food.models.DeliveryStatus;

public interface DeliveryService {

	Optional<List<DeliveryStatus>> findOrders(String name);

	Optional<DeliveryStatus> deliverOrder(DeliveryStatus delStat);

}
