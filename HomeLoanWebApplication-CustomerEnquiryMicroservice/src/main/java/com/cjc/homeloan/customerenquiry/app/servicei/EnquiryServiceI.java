package com.cjc.homeloan.customerenquiry.app.servicei;

import java.util.List;

import com.cjc.homeloan.customerenquiry.app.model.Enquiry;

public interface EnquiryServiceI {

	void saveEnquiry(Enquiry e);

	

	Enquiry findByEnquiryId(int enquiryId);

	List<Enquiry> getAllEnquiry();

	Enquiry updateEnquiryById(int enquiryId, Enquiry eq);

	Enquiry setForwardStatus(Integer enquiryId);

	List<Enquiry> FindAllCustomerCibilStatus(String status);


}
