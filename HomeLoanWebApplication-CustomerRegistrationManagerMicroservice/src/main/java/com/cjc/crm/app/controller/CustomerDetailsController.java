package com.cjc.crm.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.crm.app.model.CustomerDetails;
import com.cjc.crm.app.servicei.CustomerDetailsServiceI;


import jakarta.validation.Valid;


@RestController
@RequestMapping("/customer")
public class CustomerDetailsController {
	@Autowired
	CustomerDetailsServiceI customerServiceI;
	
	@PostMapping("/saveCustomerDetails")
	public ResponseEntity<String> saveCustomer(@Valid @RequestBody CustomerDetails c) {
		customerServiceI.saveCustomerDetails(c);
		return new ResponseEntity<String>("Customer details saved successfully..",HttpStatus.CREATED);
	}

}
