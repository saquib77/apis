package com.example.demo.models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Id;

public class Book {
	@Id
	private UUID id;
	private String name;
	private String racknum;
	private String floornum;
	private String isbn;
	private UUID userId;
	private Date created;
	private Date updated;

	public Book() {
		super();
	}

	public Book(UUID id, String name, String racknum, String floornum, String isbn, UUID userId, Date created,
			Date updated) {
		super();
		this.id = id;
		this.name = name;
		this.racknum = racknum;
		this.floornum = floornum;
		this.isbn = isbn;
		this.userId = userId;
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

	public String getRacknum() {
		return racknum;
	}

	public void setRacknum(String racknum) {
		this.racknum = racknum;
	}

	public String getFloornum() {
		return floornum;
	}

	public void setFloornum(String floornum) {
		this.floornum = floornum;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", racknum=" + racknum + ", floornum=" + floornum + ", isbn="
				+ isbn + ", userId=" + userId + ", created=" + created + ", updated=" + updated + "]";
	}
}
