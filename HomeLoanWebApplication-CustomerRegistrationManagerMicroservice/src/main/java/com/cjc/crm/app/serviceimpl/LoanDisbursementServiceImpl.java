package com.cjc.crm.app.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.crm.app.model.CustomerDetails;
import com.cjc.crm.app.model.LoanDisbursement;
import com.cjc.crm.app.repository.CustomerDetailsRepository;

import com.cjc.crm.app.servicei.LoanDisbursementServiceI;

@Service
public class LoanDisbursementServiceImpl implements LoanDisbursementServiceI{
	
	@Autowired
	CustomerDetailsRepository customerdetailsRepository;

	@Override
	public void updateCustomerDetailsWithLoanDisbursement(int customerId, LoanDisbursement disbursement) {

		CustomerDetails customer = customerdetailsRepository.findByCustomerId(customerId);
		customer.setLoanDisbursement(disbursement);
		customer.setLoanStatus("Loan Disbursed");
		customerdetailsRepository.save(customer);
		
		
	}

}
