package com.cjc.homeloan.employeeservice.app.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.cjc.homeloan.employeeservice.app.model.Employee;
import com.cjc.homeloan.employeeservice.app.servicei.EmployeeServiceI;

import lombok.extern.slf4j.Slf4j;


@CrossOrigin("http://localhost:4200")
@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeServiceI employeeServiceI;
	
	Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<String> postEmployee(@RequestBody Employee e) {
		employeeServiceI.saveEmployee(e);
		log.info("employee object saved");
		return new ResponseEntity<String>("Emloyee saved", HttpStatus.CREATED);
		
	}
	
	@GetMapping("/login/{username}/{password}")
	public ResponseEntity<Employee> loginEmployee(@PathVariable String username,
												@PathVariable String password){
		Employee employee = employeeServiceI.findByUsernameAndPassword(username,password);
		log.info("employee logged in");
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> elist = employeeServiceI.getAllEmployee();
		log.info("all employee list received");
		return new ResponseEntity<List<Employee>>(elist,HttpStatus.OK);
	}
	

}
