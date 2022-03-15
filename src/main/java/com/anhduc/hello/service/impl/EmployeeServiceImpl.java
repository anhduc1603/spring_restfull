package com.anhduc.hello.service.impl;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anhduc.hello.exceptiton.ResourceNoFoundException;
import com.anhduc.hello.model.Employee;
import com.anhduc.hello.repository.EmployeeReponsitory;
import com.anhduc.hello.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	 
	private EmployeeReponsitory emReponsitory;
	
	
	@Autowired
	public EmployeeServiceImpl(EmployeeReponsitory emReponsitory) {
		super();
		this.emReponsitory = emReponsitory;
	}



	@Override
	public Employee saveEmployee(Employee employee) {
		return emReponsitory.save(employee);
	}



	@Override
	public List<Employee> getAllEmployee() {
		return emReponsitory.findAll();
	}



	@Override
	public Employee findById(long id) {
		Optional<Employee> employee =emReponsitory.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNoFoundException("Employee","Id",id);
//		}
		return emReponsitory.findById(id).orElseThrow(()->
				new ResourceNoFoundException("Employee","Id",id));
	}



	@Override
	public Employee updateEmployee(Employee employee, long id) {
			//Check id in DB
		Employee existingEmployee = emReponsitory.findById(id).orElseThrow(()-> 
		new ResourceNoFoundException("Employee","Id",id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		emReponsitory.save(employee);
		
		return existingEmployee;
	}



	@Override
	public void deleteEmployee(long id) {
		Employee existingEmployee = emReponsitory.findById(id).orElseThrow(()-> 
		new ResourceNoFoundException("Employee","Id",id));
		emReponsitory.deleteById(id);
		
	}
		
}
