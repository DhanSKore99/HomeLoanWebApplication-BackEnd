package com.cjc.homeloan.customerenquiry.app.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

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

import com.cjc.homeloan.customerenquiry.app.exception.EnquiryNotFoundException;
import com.cjc.homeloan.customerenquiry.app.model.Enquiry;
import com.cjc.homeloan.customerenquiry.app.servicei.EnquiryServiceI;

import jakarta.validation.Valid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin("*")
@Slf4j
@RestController
@RequestMapping("/enquiry")
public class EnquiryController {

	@Autowired
	EnquiryServiceI enquiryService;

	Logger log = LoggerFactory.getLogger(EnquiryController.class);

	@PostMapping("/saveEnquiry")
	public ResponseEntity<String> saveEnquiry(@Valid @RequestBody Enquiry e) {
		e.setCibilStatus("pending");

		enquiryService.saveEnquiry(e);

		log.info("Customer object is saved into db");
		return new ResponseEntity<String>("Customer object saved", HttpStatus.CREATED);

	}

	@GetMapping("/findEnquiryById/{enquiryId}")
	public ResponseEntity<Enquiry> findByEnquiryId(@Valid @PathVariable int enquiryId) {

		if (enquiryId > 0) {
			log.info("Enquiry found by id.");
			Enquiry e = enquiryService.findByEnquiryId(enquiryId);

			return new ResponseEntity<Enquiry>(e, HttpStatus.OK);
		} else {
			throw new EnquiryNotFoundException("Enquiry not found..!!");

		}

	}

	@GetMapping("/getAllEnquiries")
	public ResponseEntity<List<Enquiry>> getAllEnquiry() {
		List<Enquiry> enquiries = enquiryService.getAllEnquiry();
		log.info("All Enquiries returned..");

		Iterator<Enquiry> iterator = enquiries.listIterator();
		while (iterator.hasNext()) {
			Enquiry e = iterator.next();
			if (e.getCibilStatus().equals("Approved")) {
				iterator.remove();
			}
		}

		return new ResponseEntity<List<Enquiry>>(enquiries, HttpStatus.OK);
	}

	@PutMapping("/updateEnquiryById/{enquiryId}")
	public Enquiry updateEnquiryById(@PathVariable int enquiryId, @RequestBody Enquiry eq) {

		Enquiry enquiry = enquiryService.updateEnquiryById(enquiryId, eq);
		log.info("Enquiry updated successfully");
		return enquiry;

	}

	@GetMapping("/setForwardStatus/{enquiryId}")
	public Enquiry setCibilStatusForward(@PathVariable Integer enquiryId) {
		Enquiry e = enquiryService.setForwardStatus(enquiryId);
		log.info("Cibil Status updated as Forwarded");
		return e;
	}

	// method to find enquiries with forwarded status

	@GetMapping("/getForwardCibilStatus")
	public ResponseEntity<List<Enquiry>> getAllCustomerCibilStatusDetails() {
		String status = "forwarded";
		List<Enquiry> list = enquiryService.FindAllCustomerCibilStatus(status);
		log.info("Customer with FORWARD ");
		return new ResponseEntity<List<Enquiry>>(list, HttpStatus.OK);
	}

	@GetMapping("calculateCibil/{id}")
	public ResponseEntity<Enquiry> calculateCibil(@PathVariable int id) {

		Enquiry existingEnq = enquiryService.findByEnquiryId(id);

		Random random = new Random();
		existingEnq.setCibilScore(random.nextInt(600, 900));
		if (existingEnq.getCibilScore() >= 600 && existingEnq.getCibilScore() <= 900) {
			existingEnq.setCibilStatus("Approved");
		} else {
			existingEnq.setCibilStatus("Rejected");
		}
		enquiryService.saveEnquiry(existingEnq);
		return new ResponseEntity<Enquiry>(existingEnq, HttpStatus.OK);
	}

	@GetMapping("getAllApprovedEnquiries")
	public ResponseEntity<List<Enquiry>> getAllVerifiedEnquiries() {
		String cibilStatus = "Approved";
		List<Enquiry> verifiedEnquiries = enquiryService.findAllEnquiriesByCibilSatus(cibilStatus);
		return new ResponseEntity<List<Enquiry>>(verifiedEnquiries, HttpStatus.OK);

	}

}
