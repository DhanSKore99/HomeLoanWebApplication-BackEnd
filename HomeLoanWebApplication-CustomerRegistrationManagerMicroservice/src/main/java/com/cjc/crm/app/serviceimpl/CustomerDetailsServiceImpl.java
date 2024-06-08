package com.cjc.crm.app.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cjc.crm.app.model.CustomerDetails;
import com.cjc.crm.app.model.EmailSender;
import com.cjc.crm.app.repository.CustomerDetailsRepository;
import com.cjc.crm.app.servicei.CustomerDetailsServiceI;

import com.netflix.discovery.provider.Serializer;

import jakarta.validation.Valid;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsServiceI{
	@Autowired
	CustomerDetailsRepository customerDetailsRepository;
	
	


	@Override
	public void saveCustomerDetails(@Valid CustomerDetails c) {
		customerDetailsRepository.save(c);
		
	}

	@Override
	public CustomerDetails findCustomerDetailsById(int customerId) {
		return customerDetailsRepository.findByCustomerId(customerId);
	}

	@Override
	public CustomerDetails updateCustomerDetails(int customerId, CustomerDetails updatedCustomerDetails) {
		CustomerDetails oldDetails  = customerDetailsRepository.findByCustomerId(customerId);
		if(oldDetails.getCustomerId() == customerId) {
			customerDetailsRepository.save(updatedCustomerDetails);
		}
		return updatedCustomerDetails;
		
	}

	
	
	
	

}
