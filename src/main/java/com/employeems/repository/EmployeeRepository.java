package com.employeems.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeems.entity.Employee;
import com.employeems.entity.User;

public interface EmployeeRepository extends JpaRepository<Employee, String>{

	
}
