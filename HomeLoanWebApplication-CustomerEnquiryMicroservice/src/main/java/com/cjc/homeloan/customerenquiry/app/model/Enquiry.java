package com.cjc.homeloan.customerenquiry.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enquiry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int enquiryId;
	private String firstName;
	private String lastName;
	private String dOB;
	private String emailId;
	private String address;
	private String adharcard;
	private String pancard;
	private long loanAmount;
	private String contactNo;
	private int cibilScore;
	private String cibilStatus;

}
