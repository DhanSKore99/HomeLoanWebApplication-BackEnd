package com.cjc.homeloan.customerenquiry.app.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

  @NotNull
	@Size(min=4,max=15,message="maximum 15 characters")
	private String firstName;
  
	@NotNull
	@Size(min=4,max=15,message="maximum 15 characters")
	private String lastName;
  
	@NotNull
  private String dateOfBirth;
  
	@Email
	private String emailId;
  
	@NotNull
  private String address;
  
	@NotEmpty
  @Size(min=14,max=14,message="Enter valid address")
	private String adharcard;
  
	@NotEmpty
	@Size(min=14,max=14,message="Enter valid address")
	private String pancard;
  
	private double annualIncome;
	@NotEmpty
  private String contactNo;
	private int cibilScore;
	private String cibilStatus;

}
