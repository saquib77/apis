package com.employee.emp.daos;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="employee")
public class EmployeeDao {
	
	@Id
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(length=16)
	private UUID id;
	
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String companyemail;
	@Column
	private String phonenum;
	@Column
	private String password;
	@Column
	private String employee_title;
	@Column
	private String previous_company;
	@OneToOne(cascade = CascadeType.ALL)
	private AddressDao address;
	@OneToOne(cascade = CascadeType.ALL)
	private DepartmentDao department;
	
	public EmployeeDao() {
		super();
	}

	public EmployeeDao(UUID id, String firstname, String lastname, String companyemail, String phonenum,
			String password, String employee_title, String previous_company,
			AddressDao address, DepartmentDao department) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.companyemail = companyemail;
		this.phonenum = phonenum;
		this.password = password;
		this.employee_title = employee_title;
		this.previous_company = previous_company;
		this.address = address;
		this.department = department;
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

	public String getCompanyemail() {
		return companyemail;
	}

	public void setCompanyemail(String companyemail) {
		this.companyemail = companyemail;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmployee_title() {
		return employee_title;
	}

	public void setEmployee_title(String employee_title) {
		this.employee_title = employee_title;
	}

	public String getPrevious_company() {
		return previous_company;
	}

	public void setPrevious_company(String previous_company) {
		this.previous_company = previous_company;
	}

	public AddressDao getAddress() {
		return address;
	}

	public void setAddress(AddressDao address) {
		this.address = address;
	}

	public DepartmentDao getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDao department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "EmployeeDao [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", companyemail="
				+ companyemail + ", phonenum=" + phonenum + ", password=" + password + ", joining_date=" + ", employee_title=" + employee_title + ", previous_company=" + previous_company
				+ ", address=" + address + ", department=" + department + "]";
	}

	
	
	
}
