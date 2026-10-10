package com.employeems.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name="employee")
public class Employee {
private int id;
@NotBlank(message="it cannot be empty,null,space")
private String name;

@Id
@Email(message="enter valid email id")
@NotBlank(message="it cannot be empty,null,space")
private String email;
@Positive(message="salary should >=0")
private double salary;
@NotBlank(message="it cannot be empty,null,space")
private String department;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", salary=" + salary + ", department="
			+ department + "]";
}

}
