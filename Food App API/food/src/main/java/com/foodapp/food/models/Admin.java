package com.foodapp.food.models;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Admin {
	@Id
	private UUID id;
	private String name;
	private String email;
	private String phnum;
	private String password;
	private Timestamp created;
	private Timestamp updated;
	public Admin() {
		super();
	}
	public Admin(UUID id, String name, String email, String phnum, String password, Timestamp created,
			Timestamp updated) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phnum = phnum;
		this.password = password;
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
	public String getPhnum() {
		return phnum;
	}
	public void setPhnum(String phnum) {
		this.phnum = phnum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", email=" + email + ", phnum=" + phnum + ", password=" + password
				+ ", created=" + created + ", updated=" + updated + "]";
	}
	
	
}
