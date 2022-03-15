package com.anhduc.hello.service;

import java.util.List;

import com.anhduc.hello.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployee();
	Employee findById(long id);
	Employee updateEmployee(Employee employee, long id);
	void deleteEmployee(long id);
}
