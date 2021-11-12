package com.retrofit.model;

import java.util.Date;
import java.util.UUID;

public class UserResponse {
	private UUID id;
	private String firstname;
	private String lastname;
	private String email;
	private String dob;
	private Date created;
	private Date updated;
	private Address address;
	public UserResponse() {
		super();
	}
	public UserResponse(UUID id, String firstname, String lastname, String email, String dob,
			Date created, Date updated, Address address) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.dob = dob;
		this.created = created;
		this.updated = updated;
		this.address = address;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserResponse [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", dob=" + dob + ", created=" + created + ", updated=" + updated
				+ ", address=" + address + "]";
	}
	
}
