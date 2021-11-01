package com.foodapp.food.models;

import java.util.UUID;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderStatus {
	@Id
	private UUID id;
	private String email;
	private String restaurantName;
	private String dishName;
	private int quantity;
	private double amount;
	private boolean payment;
	private boolean status;
	public OrderStatus() {
		super();
	}
	

	public OrderStatus(UUID id, String email, String restaurantName, String dishName, int quantity, double amount,
			boolean payment, boolean status) {
		super();
		this.id = id;
		this.email = email;
		this.restaurantName = restaurantName;
		this.dishName = dishName;
		this.quantity = quantity;
		this.amount = amount;
		this.payment = payment;
		this.status = status;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean getPayment() {
		return payment;
	}
	public void setPayment(boolean payment) {
		this.payment = payment;
	}
	
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "OrderStatus [id=" + id + ", email=" + email + ", restaurantName=" + restaurantName + ", dishName="
				+ dishName + ", quantity=" + quantity + ", amount=" + amount + ", payment=" + payment + ", status="
				+ status + "]";
	}
	
	
	
	
	
}
