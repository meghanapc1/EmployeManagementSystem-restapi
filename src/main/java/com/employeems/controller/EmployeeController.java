package com.employeems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.employeems.entity.Employee;
import com.employeems.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	
	EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping
	public String createEmployee( @Valid @RequestBody Employee employee) {
	   // return "data inserted";
	    return employeeService.createEmployee(employee);
	}

	@GetMapping("/{email}")
	public Employee fetchEmployeeById(@PathVariable String email) {
	    return employeeService.fetchEmployeeById(email);
	}

	@GetMapping
	public List<Employee> fetchAllEmployee() {
	    return employeeService.fetchAllEmployee();
	}

	@DeleteMapping("/{email}")
	public String deleteEmployeeById(@PathVariable String email) {
	    employeeService.deleteEmployeeById(email);
	    return "employee data deleted";
	}

	@PutMapping("/{email}")
	public String updateEmployeeById(@Valid @PathVariable String email,
	                                 @RequestBody Employee employee) {
	    return employeeService.updateEmployeeById(email, employee);
	}
}