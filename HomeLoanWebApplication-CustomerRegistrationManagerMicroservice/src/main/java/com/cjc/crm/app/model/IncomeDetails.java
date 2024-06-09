package com.cjc.crm.app.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class IncomeDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int incomeDetailsId;	
	private String profType;     //(employee/business)
	
	@OneToOne(cascade = CascadeType.ALL)
	private EmploymentDetails	employmentDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private BusinessDetails businessDetails;


}
