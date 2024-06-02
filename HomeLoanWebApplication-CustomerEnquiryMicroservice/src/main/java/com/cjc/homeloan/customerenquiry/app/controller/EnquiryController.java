package com.cjc.homeloan.customerenquiry.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.homeloan.customerenquiry.app.model.Enquiry;
import com.cjc.homeloan.customerenquiry.app.servicei.EnquiryServiceI;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {
	
	@Autowired
	EnquiryServiceI enquiryService;
	
	@PostMapping("/saveEnquiry")
	public String saveEnquiry(@RequestBody Enquiry e) {
		enquiryService.saveEnquiry( e);
		return "Enquiry is completed";
	}
	
	@GetMapping("/findEnquiryById/{enquiryId}")
	public Enquiry findByEnquiryId(@PathVariable int enquiryId) {
		System.out.println("getById API created....");
		System.out.println("getById API updated by Satish...");
		System.out.println("Rahul");
		return enquiryService.findByEnquiryId(enquiryId);
	}

}
