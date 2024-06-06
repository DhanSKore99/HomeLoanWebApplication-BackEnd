package com.cjc.crm.app.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.cjc.crm.app.model.CustomerDetails;
import com.cjc.crm.app.model.CustomerDocuments;
import com.cjc.crm.app.servicei.CustomerDetailsServiceI;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerDetailsController {
	@Autowired
	CustomerDetailsServiceI customerServiceI;

	Logger log = LoggerFactory.getLogger(CustomerDetailsController.class);

	@PostMapping(value = "/saveCustomerDetails", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<String> saveCustomer(
			@RequestPart("pancard") MultipartFile pancard,
			@RequestPart("photo") MultipartFile photo, 
			@RequestPart("adharcard") MultipartFile adharcard,
			@RequestPart("salarySlips") MultipartFile salarySlips,
			@RequestPart("bankStatement") MultipartFile bankStatement,
			@RequestPart("addressProof") MultipartFile addressProof,
			@RequestPart("jsonData") String json)
			throws IOException {

		ObjectMapper om = new ObjectMapper();
		CustomerDetails customerDetails = om.readValue(json, CustomerDetails.class);
		CustomerDocuments docs = customerDetails.getCustomerDocuments();
		docs.setPanCard(pancard.getBytes());
		docs.setPhoto(photo.getBytes());
		docs.setAdharCard(adharcard.getBytes());
		docs.setSalarySlips(salarySlips.getBytes());
		docs.setBankStatement(bankStatement.getBytes());
		docs.setAddressProof(addressProof.getBytes());

		customerServiceI.saveCustomerDetails(customerDetails);
		log.info("Customer details has been saved successfully..");

		return new ResponseEntity<String>("Customer details saved successfully..", HttpStatus.CREATED);
	}

}
