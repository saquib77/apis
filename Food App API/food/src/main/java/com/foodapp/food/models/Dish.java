package com.foodapp.food.models;

import java.util.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dish {
	@Id
	private UUID id;
	private String name;
	private String desc;
	private String quantity;
	private String price;
	private String rating;
	private String dishTime;
	private Date created;
	private Date updated;
	public Dish() {
		super();
	}
	public Dish(UUID id, String name, String desc, String quantity, String price, String rating, String dishTime,
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
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
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
		return "Dish [id=" + id + ", name=" + name + ", desc=" + desc + ", quantity=" + quantity + ", price=" + price
				+ ", rating=" + rating + ", dishTime=" + dishTime + ", created=" + created + ", updated=" + updated
				+ "]";
	}
	
	
	
	
}
