package com.cjc.crm.app.servicei;

import com.cjc.crm.app.model.CustomerDetails;

import jakarta.validation.Valid;

public interface CustomerDetailsServiceI {

	void saveCustomerDetails(@Valid CustomerDetails c);

}
