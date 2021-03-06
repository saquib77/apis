package com.foodapp.food.daos;

import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name="user")
public class UserDao {
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
	private String password;
	@Column
	private String phnum;
	@Column(name="created")
	private Date created;
	@Column(name="updated")
	private Date updated;
	@OneToOne(cascade = CascadeType.ALL)
	private AddressDao address;
	public UserDao() {
		super();
	}
	
	public UserDao(UUID id, String name, String email, String password, String phnum, Date created, Date updated,
			AddressDao address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phnum = phnum;
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
	public AddressDao getAddress() {
		return address;
	}
	public void setAddress(AddressDao address) {
		this.address = address;
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
		return "UserDao [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", phnum="
				+ phnum + ", created=" + created + ", updated=" + updated + ", address=" + address + "]";
	}

	
	
	
}
