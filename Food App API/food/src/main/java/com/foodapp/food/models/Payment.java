package com.foodapp.food.models;

import java.util.UUID;

import javax.persistence.Id;

public class Payment {
	@Id
	private UUID id;
	private String email;
	private String restaurantName;
	private double amount;
	private String mode;
	private UUID orderId;
	private boolean status;
	public Payment() {
		super();
	}
	
	public Payment(UUID id, String email, String restaurantName, double amount, String mode, UUID orderId,
			boolean status) {
		super();
		this.id = id;
		this.email = email;
		this.restaurantName = restaurantName;
		this.amount = amount;
		this.mode = mode;
		this.orderId = orderId;
		this.status = status;
	}

	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public UUID getOrderId() {
		return orderId;
	}
	public void setOrderId(UUID orderId) {
		this.orderId = orderId;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", email=" + email + ", restaurantName=" + restaurantName + ", amount=" + amount
				+ ", mode=" + mode + ", orderId=" + orderId + ", status=" + status + "]";
	}
	
	
}
