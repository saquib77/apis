package com.employee.emp.mappers;

import com.employee.emp.daos.AddressDao;
import com.employee.emp.daos.DepartmentDao;
import com.employee.emp.daos.EmployeeDao;
import com.employee.emp.models.Address;
import com.employee.emp.models.Department;
import com.employee.emp.models.Employee;

import org.springframework.beans.BeanUtils;

public class Mapper {
	public static EmployeeDao EmpToEmpDao(Employee emp) {
		EmployeeDao empdao = new EmployeeDao();
		empdao.setId(emp.getId());
		empdao.setCompanyemail(emp.getCompanyemail());
		empdao.setFirstname(emp.getFirstname());
		empdao.setLastname(emp.getLastname());
		empdao.setPassword(emp.getPassword());
		empdao.setPhonenum(emp.getPhonenum());
		empdao.setAddress(Mapper.AddressToAddressDao(emp.getAddress()));
		empdao.setDepartment(Mapper.DeptToDeptDao(emp.getDepartment()));
		return empdao;
	}
	
	public static Employee EmpDaoToEmp(EmployeeDao empdao) {
		Employee emp = new Employee();
		emp.setId(empdao.getId());
		emp.setCompanyemail(empdao.getCompanyemail());
		emp.setFirstname(empdao.getFirstname());
		emp.setLastname(empdao.getLastname());
		emp.setPhonenum(empdao.getPhonenum());
		emp.setAddress(Mapper.AddressDaoToAddress(empdao.getAddress()));
		emp.setDepartment(Mapper.DeptDaoToDept(empdao.getDepartment()));
		return emp;
	}
	
	public static Employee EmpDaoToEmp(EmployeeDao empdao,Employee emp) {
		emp.setId(empdao.getId());
		emp.setCompanyemail(empdao.getCompanyemail());
		emp.setFirstname(empdao.getFirstname());
		emp.setLastname(empdao.getLastname());
		emp.setPhonenum(empdao.getPhonenum());
		emp.setAddress(Mapper.AddressDaoToAddress(empdao.getAddress()));
		emp.setDepartment(Mapper.DeptDaoToDept(empdao.getDepartment()));
		return emp;
	}
	
	public static EmployeeDao UpdateEmployeeDao(Employee emp,EmployeeDao empdao) {
		empdao.setId(emp.getId()!=null ? emp.getId() : empdao.getId() );
		empdao.setCompanyemail(emp.getCompanyemail()!=null ? emp.getCompanyemail() : empdao.getCompanyemail() );
		empdao.setFirstname(emp.getFirstname()!=null ? emp.getFirstname() : empdao.getFirstname());
		empdao.setLastname(emp.getLastname()!=null ? emp.getLastname() : empdao.getLastname());
		empdao.setPhonenum(emp.getPhonenum()!=null ? emp.getPhonenum() : empdao.getPhonenum());
		empdao.setAddress( emp.getAddress()!=null ? Mapper.AddressToAddressDao(emp.getAddress()) : empdao.getAddress());
		empdao.setDepartment( emp.getDepartment()!=null ? Mapper.DeptToDeptDao(emp.getDepartment()) : empdao.getDepartment());
		return empdao;
	}
	
	public static AddressDao updateAddress(Address newaddress,AddressDao addressdao) {
		addressdao.setId(newaddress.getId()!=null ? newaddress.getId() : addressdao.getId() );
		addressdao.setHno(newaddress.getHno()!=null ? newaddress.getHno() : addressdao.getHno() );
		addressdao.setStreet(newaddress.getStreet()!=null ? newaddress.getStreet() : addressdao.getStreet());
		addressdao.setLandmark(newaddress.getLandmark()!=null ? newaddress.getLandmark() : addressdao.getLandmark());
		addressdao.setCity(newaddress.getCity()!=null ? newaddress.getCity() : addressdao.getCity());
		addressdao.setState(newaddress.getState()!=null ? newaddress.getState() : addressdao.getState());
		addressdao.setCountry(newaddress.getCountry()!=null ? newaddress.getCountry() : addressdao.getCountry());
		addressdao.setPincode(newaddress.getPincode()!=0 ? newaddress.getPincode() : addressdao.getPincode());
		return addressdao;
	}
	
	public static DepartmentDao updateDepartment(Department newdept, DepartmentDao dept) {
		dept.setId(newdept.getId()!=null ? newdept.getId() : dept.getId());
		dept.setDeptname(newdept.getDeptname()!=null ? newdept.getDeptname() : dept.getDeptname());
		dept.setJobid(newdept.getDeptname()!=null ? newdept.getDeptname() : dept.getDeptname());
		dept.setSalary(newdept.getSalary()!=null ? newdept.getSalary() : dept.getSalary());
		dept.setJoining_date(newdept.getJoining_date()!=null ? newdept.getJoining_date() : dept.getJoining_date());
		dept.setJobtype(newdept.getJobtype()!=null ? newdept.getJobtype() : dept.getJobtype());
		dept.setTechnology(newdept.getTechnology()!=null ? newdept.getTechnology() : dept.getTechnology());
		dept.setYoe(newdept.getYoe()!=0 ? newdept.getYoe() : dept.getYoe());
		return dept;
	}
	
	public static Address AddressDaoToAddress(AddressDao addressdao) {
		Address address = new Address();
		address.setId(addressdao.getId());
		BeanUtils.copyProperties(addressdao, address);
		return address;
	}
	public static AddressDao AddressToAddressDao(Address address) {
		AddressDao addressDao = new AddressDao();
		addressDao.setId(address.getId());
		BeanUtils.copyProperties(address, addressDao);
		return addressDao;
	}
	
	public static DepartmentDao DeptToDeptDao(Department dept) {
		DepartmentDao deptDao = new DepartmentDao();
		deptDao.setId(dept.getId());
		BeanUtils.copyProperties(dept, deptDao);
		return deptDao;
	}
	
	public static Department DeptDaoToDept(DepartmentDao deptdao) {
		Department dept = new Department();
		dept.setId(deptdao.getId());
		BeanUtils.copyProperties(deptdao, dept);
		return dept;
	}

	
}
