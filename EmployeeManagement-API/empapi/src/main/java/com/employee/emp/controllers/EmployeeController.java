package com.employee.emp.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.emp.models.Address;
import com.employee.emp.models.Department;
import com.employee.emp.models.Employee;
import com.employee.emp.services.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	
	// Create Employee
	@PostMapping("/register")
	public ResponseEntity<Employee> registerEmployee(@RequestBody Employee employee){
		
		if(employee!=null) {
			Optional<Employee> emp = empService.registerEmp(employee);
			if(emp.isPresent()) {
				return ResponseEntity.status(HttpStatus.CREATED).body(emp.get());
			}
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	
	//List Employee
	@GetMapping("/list")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		Optional<List<Employee>> emp = empService.getAllEmployee();
		if(emp.get().isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(emp.get());
	}
	
	//get employee by id
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") UUID id){
		Optional<Employee> emp = empService.getEmployeeById(id);
		if(emp.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(emp.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	
	//Delete Employee
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteEmp(@PathVariable UUID id){
		Optional<Employee> emp = empService.deleteEmployee(id);
		if(emp.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(emp.get());
	}
	
	
	//Update Employee Details
	@PutMapping("/{id}/update")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") UUID id ,@RequestBody Employee employee){
		Optional<Employee> emp = empService.updateEmployee(id,employee);
		if(emp.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(emp.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
	}
	
	//Partial Update (Address)
	@PatchMapping("/{id}/address")
	public ResponseEntity<Address> updateAddress(@PathVariable("id") UUID id ,@RequestBody Address address){
		Optional<Address> emp = empService.updateAddress(id,address);
		if(emp.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(emp.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	//Patch Update (Department)
	@PatchMapping("/{id}/dept")
	public ResponseEntity<Department> updateDepartment(@PathVariable("id") UUID id ,@RequestBody Department department){
		Optional<Department> emp = empService.updateDepartment(id,department);
		if(emp.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(emp.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	//Searching by firstname , lastname, email, id
	@GetMapping("/search")
	public ResponseEntity<List<Employee>> Filters(
			@RequestParam("pageSize") int pageSize,
			@RequestParam("pageNum") int pageNum,
			@RequestParam("sortBy") String sortBy,
			@RequestParam("orderBy") String orderBy,
			@RequestParam("keyword") String keyword){
		
		List<Employee> list = new ArrayList<>();
		if(keyword!=null) {
			list = empService.findByFilters(pageSize,pageNum,sortBy,orderBy,keyword);
			if(!list.isEmpty()) {
				return  ResponseEntity.status(HttpStatus.OK).body(list);
			}
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	
	
}
