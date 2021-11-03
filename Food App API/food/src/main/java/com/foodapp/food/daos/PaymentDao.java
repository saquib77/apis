package com.foodapp.food.daos;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="payment")
public class PaymentDao {
	@Id
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(length=16)
	private UUID id;
	@Column
	private String email;
	@Column
	private String restaurantName;
	@Column
	private double amount;
	@Column
	private String mode;
	@Column
	private UUID orderId;
	@Column
	private boolean status;
	public PaymentDao() {
		super();
	}
	public PaymentDao(UUID id, String email, String restaurantName, double amount, String mode, UUID orderId,
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
		return "PaymentDao [id=" + id + ", email=" + email + ", restaurantName=" + restaurantName + ", amount=" + amount
				+ ", mode=" + mode + ", orderId=" + orderId + ", status=" + status + "]";
	}
	
	
}
