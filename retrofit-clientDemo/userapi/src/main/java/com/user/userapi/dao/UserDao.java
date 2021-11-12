package com.user.userapi.dao;

import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "user")
public class UserDao {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(length=16)
	private UUID id;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String email;
	@Column
	private String password;
	@Transient
	private int address_id;
	@Column
	private Date created;
	@Column
	private Date updated;
	@Column	
	@MapKeyTemporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dob;
	@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name="id",referencedColumnName = "id")
	private AddressDao address;
	
	public UserDao() {
		super();
	}
	public UserDao(UUID id, String firstname, String lastname, String email, String password, int address_id,
			Date created, Date updated, Date dob, AddressDao address) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.address_id = address_id;
		this.created = created;
		this.updated = updated;
		this.dob = dob;
		this.address = address;
	}
	public int getAddId() {
		return this.address_id;
	}
	
	public void setAddId(int addressid) {
		this.address_id = addressid;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
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
		return "UserDao [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", address_id=" + address_id + ", created=" + created + ", updated="
				+ updated + ", dob=" + dob + ", address=" + address + "]";
	}
	
}
