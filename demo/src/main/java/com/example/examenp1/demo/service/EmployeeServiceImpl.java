package com.example.examenp1.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.examenp1.demo.model.Employee;
import com.example.examenp1.demo.repositories.EmployeeRepository;
import com.example.examenp1.demo.exception.ResourceNotFoundException;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee updateEmployee(Employee employee) {
		Optional<Employee> employeeDb = this.employeeRepository.findById(employee.getId());

		if (employeeDb.isPresent()) {
			Employee employeeUpdate = employeeDb.get();
			employeeUpdate.setId(employee.getId());
			employeeUpdate.setSurname(employee.getSurname());
			employeeUpdate.setFirstname(employee.getFirstname());

			return employeeUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + employee.getId());
		}
	}

	@Override
	public List<Employee> getAllEmployee() {
		return this.employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long employeeId) {
		Optional<Employee> employeeDb = this.employeeRepository.findById(employeeId);

		if (employeeDb.isPresent()) {
			return employeeDb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + employeeId);
		}
	}

	@Override
	public void deleteEmployee(long employeeId) {
		Optional<Employee> employeeDb = this.employeeRepository.findById(employeeId);

		if (employeeDb.isPresent()) {
			this.employeeRepository.delete(employeeDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + employeeId);
		}
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	
}
