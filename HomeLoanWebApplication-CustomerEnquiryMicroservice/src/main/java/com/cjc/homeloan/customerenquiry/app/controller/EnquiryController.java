package com.cjc.homeloan.customerenquiry.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.homeloan.customerenquiry.app.exception.EnquiryNotFoundException;
import com.cjc.homeloan.customerenquiry.app.model.Enquiry;
import com.cjc.homeloan.customerenquiry.app.servicei.EnquiryServiceI;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/enquiry")
public class EnquiryController {

	@Autowired
	EnquiryServiceI enquiryService;

	Logger log = LoggerFactory.getLogger(EnquiryController.class);

	@PostMapping("/saveEnquiry")
	public ResponseEntity<String> saveEnquiry(@Valid @RequestBody Enquiry e) {
		enquiryService.saveEnquiry(e);
		log.info("Emploee onject is saved into db");
		return new ResponseEntity<String>("employee object saved", HttpStatus.CREATED);
	}

	@GetMapping("/findEnquiryById/{enquiryId}")
	public ResponseEntity<Enquiry> findByEnquiryId(@Valid @PathVariable int enquiryId) {
		System.out.println("getById API created....");
		System.out.println("getById API updated by Satish...");

		if (enquiryId > 0) {
			log.info("Enquiry found by id.");
			Enquiry e = enquiryService.findByEnquiryId(enquiryId);
			return new ResponseEntity<Enquiry>(e, HttpStatus.OK);
		} else {
			throw new EnquiryNotFoundException("Enquiry not found..!!");

		}
	}

	// public updateEnquiryById(@PathVariable enquiry)

}
