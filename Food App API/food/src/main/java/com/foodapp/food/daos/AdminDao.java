package com.foodapp.food.daos;

import java.sql.Timestamp;
import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="admin")
public class AdminDao {
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
	private String password;
	@Column(name="created")
	private Timestamp created;
	@Column(name="updated")
	private Timestamp updated;
	public AdminDao() {
		super();
	}

	public AdminDao(UUID id, String name, String email, String phnum, String password, Timestamp created,
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

	@Override
	public String toString() {
		return "AdminDao [id=" + id + ", name=" + name + ", email=" + email + ", phnum=" + phnum + ", password="
				+ password + ", created=" + created + ", updated=" + updated + "]";
	}

	
	
}
