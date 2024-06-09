package com.cjc.crm.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmploymentDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employerId;	
	private String employerName;
	private long employerContact;
	private String employerEmail;
	private int workingFrom;
	private String designation;
	private String orgType;  //(pri/gov)

}
