package com.foodapp.food.models;

public class UserOrder {
	private String email;
	private String restaurantName;
	private String dishName;
	private int quantity;
	private boolean payment;
	public UserOrder() {
		super();
	}
	public UserOrder( String email, String restaurantName, String dishName, int quantity,
			boolean payment) {
		super();
		this.email = email;
		this.restaurantName = restaurantName;
		this.dishName = dishName;
		this.quantity = quantity;
		this.payment = payment;
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
	@Override
	public String toString() {
		return "UserOrder [email=" + email + ", restaurantName=" + restaurantName + ", dishName="
				+ dishName + ", quantity=" + quantity + ", payment=" + payment + "]";
	}
	
	
}
