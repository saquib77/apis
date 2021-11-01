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
@Table(name="deliverystatus")
public class DeliveryStatusDao {
	@Id
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(length=16)
	private UUID id;
	private String restaurantName;
	private String dishName;
	private double ammount;
	private String avgTime;
	private String address;
	private String deliveryPersonName;
	private double deliveryPersonRating;
	private boolean deliveryStatus;
	@Column(name="created")
	private Date created;
	@Column(name="updated")
	private Date updated;
	public DeliveryStatusDao() {
		super();
	}
	public DeliveryStatusDao(UUID id, String restaurantName, String dishName, double ammount, String avgTime,
			String address, String deliveryPersonName, double deliveryPersonRating, boolean deliveryStatus,
			Date created, Date updated) {
		super();
		this.id = id;
		this.restaurantName = restaurantName;
		this.dishName = dishName;
		this.ammount = ammount;
		this.avgTime = avgTime;
		this.address = address;
		this.deliveryPersonName = deliveryPersonName;
		this.deliveryPersonRating = deliveryPersonRating;
		this.deliveryStatus = deliveryStatus;
		this.created = created;
		this.updated = updated;
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
	public double getAmmount() {
		return ammount;
	}
	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}
	public String getAvgTime() {
		return avgTime;
	}
	public void setAvgTime(String avgTime) {
		this.avgTime = avgTime;
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
	public boolean getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(boolean deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	@Override
	public String toString() {
		return "DeliveryStatusDao [id=" + id + ", restaurantName=" + restaurantName + ", dishName=" + dishName
				+ ", ammount=" + ammount + ", avgTime=" + avgTime + ", address=" + address + ", deliveryPersonName="
				+ deliveryPersonName + ", deliveryPersonRating=" + deliveryPersonRating + ", deliveryStatus="
				+ deliveryStatus + ", created=" + created + ", updated=" + updated + "]";
	}
	
	
}
