package com.foodapp.food.daos;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="deliveryperson")
public class DeliveryPersonDao {
	@Id
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(length=16)
	private UUID id;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String phnum;
	@Column
	private double rating;
	@Column
	private String avgTime;
	@Column
	private int currentPincode;
	
	public DeliveryPersonDao() {
		super();
	}
	
	public DeliveryPersonDao(UUID id, String name, String email, String phnum, double rating, String avgTime,
			int currentPincode) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phnum = phnum;
		this.rating = rating;
		this.avgTime = avgTime;
		this.currentPincode = currentPincode;
	}

	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhnum() {
		return phnum;
	}
	public void setPhnum(String phnum) {
		this.phnum = phnum;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getAvgTime() {
		return avgTime;
	}
	public void setAvgTime(String avgTime) {
		this.avgTime = avgTime;
	}
	public int getCurrentPincode() {
		return currentPincode;
	}
	public void setCurrentPincode(int currentPincode) {
		this.currentPincode = currentPincode;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "DeliveryPersonDao [id=" + id + ", name=" + name + ", email=" + email + ", phnum=" + phnum + ", rating="
				+ rating + ", avgTime=" + avgTime + ", currentPincode=" + currentPincode + "]";
	}

	
	
}
