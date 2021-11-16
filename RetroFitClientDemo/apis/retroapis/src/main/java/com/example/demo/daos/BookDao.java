package com.example.demo.daos;

import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "book")
public class BookDao {
	@Id
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(length=16)
	private UUID id;
	@Column
	private String name;
	@Column
	private String racknum;
	@Column
	private String floornum;
	@Column
	private String isbn;
	@Column(length=16)
	private UUID userId;
	@Column
	private Date created;
	@Column
	private Date updated;
	public BookDao() {
		super();
	}
	public BookDao(UUID id, String name, String racknum, String floornum, String isbn, UUID userId, Date created,
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
		return "BookDao [id=" + id + ", name=" + name + ", racknum=" + racknum + ", floornum=" + floornum + ", isbn="
				+ isbn + ", userId=" + userId + ", created=" + created + ", updated=" + updated + "]";
	}
	
	
	
}
