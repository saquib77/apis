package com.foodapp.food.daos;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="dish")
public class DishDao {
	@Id
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(length=16)
	private UUID id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String desc;
	
	@Column(name="quantity")
	private String quantity;
	
	@Column(name="price")
	private String price;
	
	@Column(name="rating")
	private String rating;
	
	@Column(name="dishtime")
	private String dishTime;
	
	@Column(name="created")
	private Date created;
	@Column(name="updated")
	private Date updated;
	
	public DishDao() {
		super();
	}
	
	public DishDao(UUID id, String name, String desc, String quantity, String price, String rating, String dishTime,
			Date created, Date updated) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.quantity = quantity;
		this.price = price;
		this.rating = rating;
		this.dishTime = dishTime;
		this.created = created;
		this.updated = updated;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDishTime() {
		return dishTime;
	}

	public void setDishTime(String dishTime) {
		this.dishTime = dishTime;
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
		return "DishDao [id=" + id + ", name=" + name + ", desc=" + desc + ", quantity=" + quantity + ", price=" + price
				+ ", rating=" + rating + ", dishTime=" + dishTime + ", created=" + created + ", updated=" + updated
				+ "]";
	}

	

	


	
	
	
	
}
