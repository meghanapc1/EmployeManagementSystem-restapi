package com.employeems.service;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.employeems.entity.Employee;
import com.employeems.repository.EmployeeRepository;

@Service
public class EmployeeService {

	EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	    public String createEmployee(Employee employee) {
	        employeeRepository.save(employee);
	        return "employee data inserted";
	    }

	    public Employee fetchEmployeeById(String email) {
	        return employeeRepository.findById(email).orElse(null);
	    }

	    public List<Employee> fetchAllEmployee() {
	        return employeeRepository.findAll();
	    }

	    public void deleteEmployeeById(String email) {
	        employeeRepository.deleteById(email);
	    }

	    public String updateEmployeeById(String email, Employee employee) {
	        employee.setEmail(email);
	        employeeRepository.save(employee);
	        return "employee data updated";
	    }
	}