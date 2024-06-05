package com.cjc.crm.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.crm.app.model.CustomerDetails;
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

}
