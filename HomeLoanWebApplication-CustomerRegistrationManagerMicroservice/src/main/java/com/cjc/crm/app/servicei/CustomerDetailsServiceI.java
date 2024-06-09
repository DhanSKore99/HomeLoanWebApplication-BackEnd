package com.cjc.crm.app.servicei;

import com.cjc.crm.app.model.CustomerDetails;
import com.cjc.crm.app.model.EmailSender;

import jakarta.validation.Valid;

public interface CustomerDetailsServiceI {

	void saveCustomerDetails(@Valid CustomerDetails c);

	CustomerDetails findCustomerDetailsById(int customerId);

	CustomerDetails updateCustomerDetails(int customerId, CustomerDetails previousCustomerDetails);

	


}
