package com.foodapp.food.models;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
	@Id
	private UUID id;
	private String name;
	private String email;
	private String password;
	private String phnum;
	private Address address;
	private Timestamp created;
	private Timestamp updated;
	public User() {
		super();
	}
	public User(UUID id, String name, String email, String password, String phnum, Address address, Timestamp created,
			Timestamp updated) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phnum = phnum;
		this.address = address;
		this.created = created;
		this.updated = updated;
	}
	
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public Timestamp getUpdated() {
		return updated;
	}
	public void setUpdated(Timestamp updated) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhnum() {
		return phnum;
	}
	public void setPhnum(String phnum) {
		this.phnum = phnum;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", phnum=" + phnum
				+ ", address=" + address + ", created=" + created + ", updated=" + updated + "]";
	}
	
	
}
