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
	@Column(name="created")
	private Date created;
	@Column(name="updated")
	private Date updated;
	public DeliveryPersonDao() {
		super();
	}

	public DeliveryPersonDao(UUID id, String name, String email, String phnum, double rating, String avgTime,
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
				+ rating + ", avgTime=" + avgTime + ", currentPincode=" + currentPincode + ", created=" + created
				+ ", updated=" + updated + "]";
	}

	

	
	
}
