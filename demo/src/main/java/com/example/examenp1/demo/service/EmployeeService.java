package com.example.examenp1.demo.service;

import java.util.List;

import com.example.examenp1.demo.model.Employee;

public interface EmployeeService {

	Employee updateEmployee(Employee employee);
	
	List<Employee> getAllEmployee();

	Employee getEmployeeById(long employeeId);

	void deleteEmployee(long id);
}