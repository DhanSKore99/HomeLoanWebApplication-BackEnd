package com.cjc.crm.app.servicei;

import com.cjc.crm.app.model.LoanDisbursement;

public interface LoanDisbursementServiceI {

	void updateCustomerDetailsWithLoanDisbursement(int customerId, LoanDisbursement disbursement);

}
