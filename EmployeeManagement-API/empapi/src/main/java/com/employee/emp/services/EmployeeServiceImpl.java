package com.employee.emp.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.emp.daos.AddressDao;
import com.employee.emp.daos.DepartmentDao;
import com.employee.emp.daos.EmployeeDao;
import com.employee.emp.mappers.Mapper;
import com.employee.emp.models.Address;
import com.employee.emp.models.Department;
import com.employee.emp.models.Employee;
import com.employee.emp.repositories.EmpRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmpRepository empRepo;
	
	@Override
	public Optional<Employee> registerEmp(Employee employee) {
		Optional<EmployeeDao> empDb = empRepo.findByCompanyEmail(employee.getCompanyemail());
		if(empDb.isEmpty()) {
			EmployeeDao empDao = Mapper.EmpToEmpDao(employee);
			empRepo.save(empDao);
			Employee emp = Mapper.EmpDaoToEmp(empDao);
			return Optional.of(emp);
		}
		return Optional.empty();
	}

	@Override
	public Optional<List<Employee>> getAllEmployee() {
		List<EmployeeDao> listDb = empRepo.findAll();
		List<Employee> list = new ArrayList<>();
		for(EmployeeDao e : listDb) {
			list.add(Mapper.EmpDaoToEmp(e, new Employee()));
		}
		return Optional.of(list);
	}

	@Override
	public Optional<Employee> deleteEmployee(UUID id) {
		Optional<EmployeeDao> emp = empRepo.findById(id);
		if(emp.isPresent()) {
			empRepo.delete(emp.get());
			return Optional.of(Mapper.EmpDaoToEmp(emp.get(), new Employee()));
		}
		return Optional.empty();
	}

	@Override
	public Optional<Employee> updateEmployee(UUID id,Employee emp_new) {
		Optional<EmployeeDao> emp = empRepo.findById(id);
		if(emp.isPresent()) {
			 EmployeeDao empdao = Mapper.UpdateEmployeeDao(emp_new, emp.get());
			 empRepo.save(empdao);
			 return Optional.of(Mapper.EmpDaoToEmp(empdao));
		}
		return Optional.empty();
	}

	@Override
	public Optional<Employee> getEmployeeById(UUID id) {
		Optional<EmployeeDao> empDb = empRepo.findById(id);
		if(empDb.isPresent()) {
			return Optional.of(Mapper.EmpDaoToEmp(empDb.get()));
		}
		return Optional.empty();
	}

	@Override
	public Optional<Address> updateAddress(UUID id, Address address) {
		Optional<EmployeeDao> empDb = empRepo.findById(id);
		if(empDb.isPresent()) {
			AddressDao updatedAddress =	Mapper.updateAddress(address,empDb.get().getAddress());
			empDb.get().setAddress(updatedAddress);
			empRepo.save(empDb.get());
			return Optional.of(Mapper.AddressDaoToAddress(updatedAddress));
		}
		return Optional.empty();
	}

	@Override
	public Optional<Department> updateDepartment(UUID id, Department department) {
		Optional<EmployeeDao> empDb = empRepo.findById(id);
		if(empDb.isPresent()) {
			DepartmentDao deptDao =	Mapper.updateDepartment(department,empDb.get().getDepartment());
			empDb.get().setDepartment(deptDao);
			empRepo.save(empDb.get());
			return Optional.of(Mapper.DeptDaoToDept(deptDao));
		}
		return Optional.empty();
	}

	@Override
	public List<Employee> findByFilters(int pageSize, int pageNum, String sortBy, String orderBy, String keyword) {		
		List<EmployeeDao> listDb = empRepo.findByKeyword(keyword);
		List<Employee> list = new ArrayList<>(); 
		for(EmployeeDao e : listDb) {
			list.add(Mapper.EmpDaoToEmp(e));
		}
		list = list.stream().skip(pageNum).limit(pageSize).collect(Collectors.toList());
		if(sortBy.equals("firstname")) {
			sortEmployeeFirstName(list);
			return list;
		}else if(sortBy.equals("lastname")) {
			sortEmployeeLastName(list);
			return list;
		}else if(sortBy.equals("email")) {
			sortEmployeeEmail(list);
			return list;
		}else if(sortBy.equals("id")) {
			sortEmployeeId(list);
			return list;
		}
		return list;
	}

	
	
	
	
	public static void sortEmployeeFirstName(List<Employee> list) {
		Collections.sort(list, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				int res = o1.getFirstname().compareToIgnoreCase(o2.getFirstname());
				if(res!=0) return res;
				return o1.getFirstname().compareToIgnoreCase(o2.getFirstname());
			}
		});
	}

	public static void sortEmployeeLastName(List<Employee> list) {
		Collections.sort(list, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				int res = o1.getLastname().compareToIgnoreCase(o2.getLastname());
				if(res!=0) return res;
				return o1.getLastname().compareToIgnoreCase(o2.getLastname());
			}
		});
	}

	public static void sortEmployeeEmail(List<Employee> list) {
		Collections.sort(list, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				int res = o1.getCompanyemail().compareToIgnoreCase(o2.getCompanyemail());
				if(res!=0) return res;
				return o1.getCompanyemail().compareToIgnoreCase(o2.getCompanyemail());
			}
		});
	}
	
	public static void sortEmployeeId(List<Employee> list) {
		Collections.sort(list, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				int res = o1.getId().compareTo(o2.getId());
				if(res!=0) return res;
				return o1.getId().compareTo(o2.getId());
			}
		});
	}
	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
