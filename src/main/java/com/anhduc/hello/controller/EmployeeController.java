package com.anhduc.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anhduc.hello.model.Employee;
import com.anhduc.hello.model.Transcript;
import com.anhduc.hello.service.EmployeeService;
import com.anhduc.hello.service.TranscriptService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	
		@Autowired
		private EmployeeService employeeService;
		
		@Autowired
		private TranscriptService transcriptService;

		@PostMapping("/test")
		public void addTest() {
			Employee employee= new Employee("Ha Anh Duc","Duc","st@gmail.com");
			employeeService.saveEmployee(employee);
			
			Transcript transcript = new Transcript(3, 4, 5,employee);
			transcriptService.saveTrancript(transcript);
		}
		
		//create
		@PostMapping("new")
		public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
			return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),
					HttpStatus.CREATED);
		}
		
		
		//get All employee
		@GetMapping("all")
		public List<Employee> getAllEmployee(){
			return employeeService.getAllEmployee();
		}
		
		//get employee by id
		@GetMapping("{id}")
		public ResponseEntity<Employee> getbyIdEmployee(@PathVariable("id") long id){
			return new ResponseEntity<Employee>(employeeService.findById(id),HttpStatus.OK);
		}
		
		//update employee
		@PutMapping("{id}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,
				@RequestBody Employee employee){
			return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id)
					,HttpStatus.OK);
		}
		
		//Delete Employee
		@DeleteMapping(value ="/delete/{id}")
		public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
			employeeService.deleteEmployee(id);
			return new ResponseEntity<String>("Delete successfully. ", HttpStatus.OK);
		}
}
