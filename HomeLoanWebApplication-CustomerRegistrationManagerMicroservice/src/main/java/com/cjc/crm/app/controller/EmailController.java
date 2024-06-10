package com.cjc.crm.app.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.crm.app.model.CustomerDetails;
import com.cjc.crm.app.servicei.CustomerDetailsServiceI;
import com.cjc.crm.app.servicei.EmailServiceI;


@RestController
@CrossOrigin("*")
@RequestMapping("/mail")
public class EmailController 
{ 
	@Autowired
	EmailServiceI emailservice;
	
	@Autowired
	CustomerDetailsServiceI cs;
	
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	@GetMapping("/sendSantionLetterMail/{customerId}")
	public CustomerDetails sendSanctionLetterMail(@PathVariable("customerId") Integer customerId)
	{
		System.out.println("Mail sending started");
		Optional<CustomerDetails> customerdetail = cs.findById(customerId);
		CustomerDetails customerDetails = customerdetail.get();
		if(customerdetail.isPresent())
		{
			emailservice.sendSantionLetterMail(customerDetails);
			return customerDetails;
		}
		else
		{
			return null;
		}
	}
}
