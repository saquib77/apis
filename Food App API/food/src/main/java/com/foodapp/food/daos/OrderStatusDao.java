package com.foodapp.food.daos;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="orderstatus")
public class OrderStatusDao {
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
	private String dishName;
	@Column
	private int quantity;
	@Column
	private double amount;
	@Column
	private boolean payment;
	@Column
	private boolean status;
	@Column(name="created")
	private Date created;
	@Column(name="updated")
	private Date updated;
	public OrderStatusDao() {
		super();
	}
	public OrderStatusDao(UUID id, String email, String restaurantName, String dishName, int quantity, double amount,
			boolean payment, boolean status, Date created, Date updated) {
		super();
		this.id = id;
		this.email = email;
		this.restaurantName = restaurantName;
		this.dishName = dishName;
		this.quantity = quantity;
		this.amount = amount;
		this.payment = payment;
		this.status = status;
		this.created = created;
		this.updated = updated;
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
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
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
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	@Override
	public String toString() {
		return "OrderStatusDao [id=" + id + ", email=" + email + ", restaurantName=" + restaurantName + ", dishName="
				+ dishName + ", quantity=" + quantity + ", amount=" + amount + ", payment=" + payment + ", status="
				+ status + ", created=" + created + ", updated=" + updated + "]";
	}
	
}
