package com.cjc.homeloan.customerenquiry.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.homeloan.customerenquiry.app.model.Enquiry;
import com.cjc.homeloan.customerenquiry.app.repository.EnquiryRepository;
import com.cjc.homeloan.customerenquiry.app.servicei.EnquiryServiceI;

@Service
public class EnquiryServiceImpl implements EnquiryServiceI {
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

	@Override
	public Enquiry updateEnquiryById(int enquiryId, Enquiry eq) {

		java.util.Optional<Enquiry> enquiry=enquiryRepository.findById(enquiryId);
		if(enquiry.isPresent())
		{
			Enquiry e=enquiry.get();
			
			if(eq.getFirstName()!=null) 
			{
				e.setFirstName(eq.getFirstName());
			
						if(eq.getLastName()!=null)
						{
							e.setLastName(eq.getLastName());
						}
						if(eq.getDateOfBirth()!=null)
						{
							e.setDateOfBirth(eq.getDateOfBirth());
							
						}
						if(eq.getEmailId()!=null)
						{
							e.setEmailId(eq.getEmailId());
						}
						if(eq.getAddress()!=null)
						{
							e.setAddress(eq.getAddress());
						}
						if(eq.getAdharcard()!=null)
						{
							e.setAdharcard(eq.getAdharcard());
						}
						if(eq.getPancard()!=null)
						{
							e.setPancard(eq.getPancard());
							
						}
						
						if(eq.getAnnualIncome()!= 0) {
							e.setAnnualIncome(eq.getAnnualIncome());
						}
						
						if(eq.getContactNo()!=null)
						{
							e.setContactNo(eq.getContactNo());
						}
						
		}
		return enquiryRepository.save(e);
	}else
	{
		return null;
	}
		
		
		
	}

	@Override
	public Enquiry setForwardStatus(Integer enquiryId) {
		java.util.Optional<Enquiry> enquiry=enquiryRepository.findById(enquiryId);
		if(enquiry.isPresent())
		{
			Enquiry e=enquiry.get();
			e.setCibilStatus("Forwarded");
			enquiryRepository.save(e);
			return e;
		}
		return null;
	}

	@Override
	public List<Enquiry> FindAllCustomerCibilStatus(String status) {
		 return enquiryRepository.findByCibilStatus(status);
	}

	@Override
	public List<Enquiry> findAllEnquiriesByCibilSatus(String cibilStatus) {
		return enquiryRepository.findAllByCibilStatus(cibilStatus);
	}


	
	
}
