package com.employee.emp.models;

import java.util.UUID;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {
	@Id
	private UUID id;
	private String firstname;
	private String lastname;
	private String companyemail;
	private String phonenum;
	private String password;
	private String employee_title;
	private String previous_company;
	private Address address;
	private Department department;
	public Employee() {
		super();
	}
	
	public Employee(UUID id, String firstname, String lastname, String companyemail, String phonenum, String password,
			String employee_title, String previous_company, Address address,
			Department department) {
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


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", companyemail="
				+ companyemail + ", phonenum=" + phonenum + ", password=" + password + ", joining_date=" + ", employee_title=" + employee_title + ", previous_company=" + previous_company
				+ ", address=" + address + ", department=" + department + "]";
	}
	
	
	
}
