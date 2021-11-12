package com.user.userapi.model;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {
	@Id
	private UUID id;
	private int hno;
	private String street;
	private String city;
	private String state;
	private String country;
	private int pincode;
	private Date created;
	private Date updated;
	public Address() {
		super();
	}
	public Address(UUID id, int hno, String street, String city, String state, String country, int pincode,
			Date created, Date updated) {
		super();
		this.id = id;
		this.hno = hno;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.created = created;
		this.updated = updated;
	}

	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public int getHno() {
		return hno;
	}
	public void setHno(int hno) {
		this.hno = hno;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
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
		return "Address [id=" + id + ", hno=" + hno + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", pincode=" + pincode + ", created=" + created + ", updated=" + updated
				+ "]";
	}
}
