package com.cjc.homeloan.customerenquiry.app.servicei;

import java.util.List;

import com.cjc.homeloan.customerenquiry.app.model.Enquiry;

public interface EnquiryServiceI {

	void saveEnquiry(Enquiry e);

	//Enquiry findByEnquiryId(Enquiry enquiryId);

	Enquiry findByEnquiryId(int enquiryId);

	List<Enquiry> getAllEnquiry();

}
