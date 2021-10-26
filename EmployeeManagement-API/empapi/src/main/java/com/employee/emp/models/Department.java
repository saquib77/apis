package com.employee.emp.models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Department {
	@Id
	private UUID id;
	private String deptname;
	private String jobid;
	private String salary;
	private Float yoe;
	private Date joining_date;
	private String jobtype;
	private String technology;
	
	public Department() {
		super();
	}

	public Department(UUID id, String deptname, String jobid, String salary, Float yoe, Date joining_date,
			String jobtype, String technology) {
		super();
		this.id = id;
		this.deptname = deptname;
		this.jobid = jobid;
		this.salary = salary;
		this.yoe = yoe;
		this.joining_date = joining_date;
		this.jobtype = jobtype;
		this.technology = technology;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Float getYoe() {
		return yoe;
	}

	public void setYoe(Float yoe) {
		this.yoe = yoe;
	}

	public Date getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(Date joining_date) {
		this.joining_date = joining_date;
	}

	public String getJobtype() {
		return jobtype;
	}

	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", deptname=" + deptname + ", jobid=" + jobid + ", salary=" + salary + ", yoe="
				+ yoe + ", joining_date=" + joining_date + ", jobtype=" + jobtype + ", technology=" + technology + "]";
	}

	

	
}
