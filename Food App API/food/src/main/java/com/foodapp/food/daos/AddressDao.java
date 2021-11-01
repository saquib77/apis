package com.foodapp.food.daos;

import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="address")
public class AddressDao {
	
	@Id
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(length=16)
	private UUID id;
	
	@Column
	private String hno;
	@Column
	private String street;
	@Column
	private String landmark;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String country;
	@Column
	private int pincode;
	@OneToOne(mappedBy = "address")
	private UserDao user;
	public AddressDao() {
		super();
	}
	public AddressDao(UUID id, String hno, String street, String landmark, String city, String state, String country,
			int pincode, UserDao user) {
		super();
		this.id = id;
		this.hno = hno;
		this.street = street;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.user = user;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getHno() {
		return hno;
	}
	public void setHno(String hno) {
		this.hno = hno;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
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
	public UserDao getUser() {
		return user;
	}
	public void setUser(UserDao user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "AddressDao [id=" + id + ", hno=" + hno + ", street=" + street + ", landmark=" + landmark + ", city="
				+ city + ", state=" + state + ", country=" + country + ", pincode=" + pincode + ", user=" + user + "]";
	}
	
	
	
}
