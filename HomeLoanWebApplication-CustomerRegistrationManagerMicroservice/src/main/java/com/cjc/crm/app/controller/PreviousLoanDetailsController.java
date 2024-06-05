package com.cjc.crm.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.crm.app.servicei.PreviousLoanDetailsServiceI;




@RestController
public class PreviousLoanDetailsController {
	@Autowired
	PreviousLoanDetailsServiceI previousLoanDServiceI;

}
