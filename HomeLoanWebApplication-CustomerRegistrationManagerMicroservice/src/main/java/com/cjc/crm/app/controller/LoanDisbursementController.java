package com.cjc.crm.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.crm.app.model.LoanDisbursement;
import com.cjc.crm.app.servicei.LoanDisbursementServiceI;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/disbursement")
public class LoanDisbursementController {
	@Autowired
	LoanDisbursementServiceI loanDisbusementServiceI;
	
	@PutMapping("/saveDisbursedCustomerEntry/{customerId}")
	public ResponseEntity<String> updateCustomerDetailsWithLoanDisbursement(@PathVariable int customerId,
																	@RequestBody LoanDisbursement disbursement){
		loanDisbusementServiceI.updateCustomerDetailsWithLoanDisbursement(customerId,disbursement);
		return new ResponseEntity<String>("LoanDisbursement updated Successfully in CustomerDetails", HttpStatus.OK);
	}

}
