package com.cjc.homeloan.customerenquiry.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.homeloan.customerenquiry.app.model.Enquiry;
import com.cjc.homeloan.customerenquiry.app.repository.EnquiryRepository;
import com.cjc.homeloan.customerenquiry.app.servicei.EnquiryServiceI;

@Service
public class EnquiryServiceImpl implements EnquiryServiceI{
	@Autowired 
	EnquiryRepository enquiryRepository;

	@Override
	public void saveEnquiry(Enquiry e) {
		enquiryRepository.save(e);
		
	}

	@Override
	public Enquiry findByEnquiryId(int enquiryId) {
		return enquiryRepository.findByEnquiryId(enquiryId);
	}

	@Override
	public List<Enquiry> getAllEnquiry() {
		return enquiryRepository.findAll();
		}

}
