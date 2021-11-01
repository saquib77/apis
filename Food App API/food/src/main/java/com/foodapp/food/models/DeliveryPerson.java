package com.foodapp.food.models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryPerson {
	@Id
	private UUID id;
	private String name;
	private String email;
	private String phnum;
	private double rating;
	private String avgTime;
	private int currentPincode;
	private Date created;
	private Date updated;
	public DeliveryPerson() {
		super();
	}
	public DeliveryPerson(UUID id, String name, String email, String phnum, double rating, String avgTime,
			int currentPincode, Date created, Date updated) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phnum = phnum;
		this.rating = rating;
		this.avgTime = avgTime;
		this.currentPincode = currentPincode;
		this.created = created;
		this.updated = updated;
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
		return "DeliveryPerson [id=" + id + ", name=" + name + ", email=" + email + ", phnum=" + phnum + ", rating="
				+ rating + ", avgTime=" + avgTime + ", currentPincode=" + currentPincode + ", created=" + created
				+ ", updated=" + updated + "]";
	}
	
}
