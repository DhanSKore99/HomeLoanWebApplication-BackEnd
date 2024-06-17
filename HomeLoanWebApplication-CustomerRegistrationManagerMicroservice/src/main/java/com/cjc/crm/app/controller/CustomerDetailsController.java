package com.cjc.crm.app.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.cjc.crm.app.model.CustomerDetails;
import com.cjc.crm.app.model.CustomerDocuments;

import com.cjc.crm.app.servicei.CustomerDetailsServiceI;
import com.cjc.crm.app.servicei.EmailServiceI;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
@CrossOrigin("*")
@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerDetailsController {
	@Autowired
	CustomerDetailsServiceI customerServiceI;

	@Autowired
	EmailServiceI emailServiceI;

	Logger log = LoggerFactory.getLogger(CustomerDetailsController.class);

	@PostMapping(value = "/saveCustomerDetails", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<String> saveCustomer(@RequestPart("pancard") MultipartFile pancard,
			@RequestPart("photo") MultipartFile photo, @RequestPart("adharcard") MultipartFile adharcard,
			@RequestPart("salarySlips") MultipartFile salarySlips,
			@RequestPart("bankStatement") MultipartFile bankStatement,
			@RequestPart("addressProof") MultipartFile addressProof, @RequestPart("jsonData") String json

	) throws IOException {

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
		log.info(customerDetails.getLoanStatus());
		sendEmail(customerDetails.getEmailId());
		log.info("Customer details has been saved successfully..");

		return new ResponseEntity<String>("Customer details saved successfully..", HttpStatus.CREATED);
	}

	@GetMapping("/getCustomerDetailsById/{customerId}")
	public ResponseEntity<CustomerDetails> getCustomerDetails(@PathVariable int customerId) {
		CustomerDetails customerDetails = customerServiceI.findCustomerDetailsById(customerId);
		log.info("customerDetails get by customerId");
		return new ResponseEntity<CustomerDetails>(customerDetails, HttpStatus.OK);
	}

	@PutMapping(value = "/updateCustomerDetails/{customerId}", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<CustomerDetails> updateCustomerDetails(@PathVariable int customerId,
			@RequestPart("pancard") MultipartFile pancard, @RequestPart("photo") MultipartFile photo,
			@RequestPart("adharcard") MultipartFile adharcard, @RequestPart("salarySlips") MultipartFile salarySlips,
			@RequestPart("bankStatement") MultipartFile bankStatement,
			@RequestPart("addressProof") MultipartFile addressProof, @RequestPart("jsonData") String json)
			throws IOException {

		ObjectMapper om = new ObjectMapper();
		CustomerDetails previousCustomerDetails = om.readValue(json, CustomerDetails.class);
		CustomerDocuments updatedDocs = previousCustomerDetails.getCustomerDocuments();

		System.out.println("original name" + previousCustomerDetails.getCustomerName());

		updatedDocs.setPanCard(pancard.getBytes());
		updatedDocs.setPhoto(photo.getBytes());
		updatedDocs.setAdharCard(adharcard.getBytes());
		updatedDocs.setSalarySlips(salarySlips.getBytes());
		updatedDocs.setBankStatement(bankStatement.getBytes());
		updatedDocs.setAddressProof(addressProof.getBytes());

		CustomerDetails updatedCustomerDetails = customerServiceI.updateCustomerDetails(customerId,
				previousCustomerDetails);
			sendUpdates(updatedCustomerDetails.getEmailId());
		return new ResponseEntity<CustomerDetails>(updatedCustomerDetails, HttpStatus.OK);

	}

	public String sendEmail(String receipientEmail) {
		emailServiceI.sendEmail(receipientEmail);
		return "email sent";

	}
	
	public String sendUpdates(String receipientEmail) {
		emailServiceI.sendUpdates(receipientEmail);
		return "email sent";
	}
	
	@GetMapping("/getAllCustomerDetails")
	public ResponseEntity<List<CustomerDetails>> getAllCustomerDetails(){
		List<CustomerDetails> list = customerServiceI.getAllCustomerDetails();
		log.info("All customer's deatils fetched from db.");
		return new ResponseEntity<List<CustomerDetails>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/updateverificationstatus/{customerId}")
	public ResponseEntity<String> updateVerificationStatus(@PathVariable int customerId){
		 customerServiceI.updateStatus(customerId);
		
		
		return new ResponseEntity<String>("Documents Verified", HttpStatus.OK);
	}
	
	@GetMapping("/getAllVerifiedCustomers")
	public ResponseEntity<List<CustomerDetails>> getAllVerifiedCustomers(){
		List<CustomerDetails> verifiedList= customerServiceI.getAllVerifiedCustomers();
		return new ResponseEntity<List<CustomerDetails>>(verifiedList, HttpStatus.OK);
	}

}
