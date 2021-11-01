package com.foodapp.food.models;
import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Menu {
	@Id
	private UUID id;
	private String adminEmail;
	private String restaurantName;
	private String menuCardName;
	private Date created;
	private Date updated;
	private List<Dish> dishList;
	public Menu() {
		super();
	}
	public Menu(UUID id, String adminEmail, String restaurantName, String menuCardName, Date created, Date updated,
			List<Dish> dishList) {
		super();
		this.id = id;
		this.adminEmail = adminEmail;
		this.restaurantName = restaurantName;
		this.menuCardName = menuCardName;
		this.created = created;
		this.updated = updated;
		this.dishList = dishList;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getMenuCardName() {
		return menuCardName;
	}
	public void setMenuCardName(String menuCardName) {
		this.menuCardName = menuCardName;
	}
	public List<Dish> getDishList() {
		return dishList;
	}
	public void setDishList(List<Dish> dishList) {
		this.dishList = dishList;
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
		return "Menu [id=" + id + ", adminEmail=" + adminEmail + ", restaurantName=" + restaurantName
				+ ", menuCardName=" + menuCardName + ", created=" + created + ", updated=" + updated + ", dishList="
				+ dishList + "]";
	}
	
}
