package com.employee.emp.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.employee.emp.models.Address;
import com.employee.emp.models.Department;
import com.employee.emp.models.Employee;

public interface EmployeeService {
	Optional<Employee> registerEmp(Employee employee);
	Optional<List<Employee>> getAllEmployee();
	Optional<Employee> deleteEmployee(UUID id);
	Optional<Employee> updateEmployee(UUID id,Employee employee);
	Optional<Employee> getEmployeeById(UUID id);
	Optional<Address> updateAddress(UUID id,Address address);
	Optional<Department> updateDepartment(UUID id,Department department);
	List<Employee> findByFilters(int pageSize,int pageNum,String sortBy,String orderBy,String keyword);
}
