package com.cjc.crm.app.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Customers")
public class CustomerDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private String customerName;
	private String customerDateOfBirth;
	private String customerGender;
	private String maritalStatus;
	private Double loanAmount;
	private String emailId;
	private Long mobileNumber;
	private String pancardNumber;
	private String adhaarNumber;
	private String address;

	@OneToOne(cascade = CascadeType.ALL)
	private CustomerBankDetails customerBankDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PreviousLoanDetails previousLoanDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerDocuments customerDocuments;
	
	@OneToOne(cascade = CascadeType.ALL)
	private SanctionedLoanDetails sactionedLoanDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PropertyDetails propertyDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private GuarantorDetails guarantorDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private IncomeDetails incomeDetails;



	
	
	

}
