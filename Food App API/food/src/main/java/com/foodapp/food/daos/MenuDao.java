package com.foodapp.food.daos;

import java.sql.Timestamp;
import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="menu")
public class MenuDao {
	@Id
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(length=16,name="id")
	private UUID id;
	
	@Column(name="adminEmail")
	private String adminEmail;
	
	@Column(name="restaurantName")
	private String restaurantName;
	
	@Column(name="menuCardName")
	private String menuCardName;
	@Column
	private Timestamp created;
	@Column
	private Timestamp updated;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="menu_fk",referencedColumnName = "id")
	private List<DishDao> dishList;
	
	public MenuDao() {
		super();
	}
	public MenuDao(UUID id, String adminEmail, String restaurantName, String menuCardName, Timestamp created,
			Timestamp updated, List<DishDao> dishList) {
		super();
		this.id = id;
		this.adminEmail = adminEmail;
		this.restaurantName = restaurantName;
		this.menuCardName = menuCardName;
		this.created = created;
		this.updated = updated;
		this.dishList = dishList;
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

	public List<DishDao> getDishList() {
		return dishList;
	}

	public void setDishList(List<DishDao> dishList) {
		this.dishList = dishList;
	}

	@Override
	public String toString() {
		return "MenuDao [id=" + id + ", adminEmail=" + adminEmail + ", restaurantName=" + restaurantName
				+ ", menuCardName=" + menuCardName + ", created=" + created + ", updated=" + updated + ", dishList="
				+ dishList + "]";
	}


	
	
}
