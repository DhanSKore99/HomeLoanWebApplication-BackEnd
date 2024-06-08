package com.cjc.homeloan.customerenquiry.app.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

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
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;
	@NotEmpty
	private String dateOfBirth;
	@Email
	private String emailId;
	private String address;
	@NotEmpty
	private String adharcard;
	@NotEmpty
	private String pancard;
	private Double annualIncome;
	private String contactNo;
	private int cibilScore;
	private String cibilStatus;

}
