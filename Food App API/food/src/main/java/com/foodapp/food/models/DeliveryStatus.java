package com.foodapp.food.models;

import java.util.UUID;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryStatus {
	@Id
	private UUID id;
	private String restaurantName;
	private String dishName;
	private double ammount;
	private String estTime;
	private String address;
	private String deliveryPersonName;
	private double deliveryPersonRating;
	private boolean deliveryStatus;
	public DeliveryStatus() {
		super();
	}
	public DeliveryStatus(String restaurantName, String dishName, double ammount, String estTime, String address,
			String deliveryPersonName, double deliveryPersonRating, boolean deliveryStatus) {
		super();
		this.restaurantName = restaurantName;
		this.dishName = dishName;
		this.ammount = ammount;
		this.estTime = estTime;
		this.address = address;
		this.deliveryPersonName = deliveryPersonName;
		this.deliveryPersonRating = deliveryPersonRating;
		this.deliveryStatus = deliveryStatus;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public double getAmmount() {
		return ammount;
	}
	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}
	public String getEstTime() {
		return estTime;
	}
	public void setEstTime(String estTime) {
		this.estTime = estTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDeliveryPersonName() {
		return deliveryPersonName;
	}
	public void setDeliveryPersonName(String deliveryPersonName) {
		this.deliveryPersonName = deliveryPersonName;
	}
	public double getDeliveryPersonRating() {
		return deliveryPersonRating;
	}
	public void setDeliveryPersonRating(double deliveryPersonRating) {
		this.deliveryPersonRating = deliveryPersonRating;
	}
	public boolean isDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(boolean deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	@Override
	public String toString() {
		return "DeliveryStatus [restaurantName=" + restaurantName + ", dishName=" + dishName + ", ammount=" + ammount
				+ ", estTime=" + estTime + ", address=" + address + ", deliveryPersonName=" + deliveryPersonName
				+ ", deliveryPersonRating=" + deliveryPersonRating + ", deliveryStatus=" + deliveryStatus + "]";
	}
	
	
}
