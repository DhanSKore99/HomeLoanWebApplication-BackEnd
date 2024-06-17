package com.cjc.crm.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PreviousLoanDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loanId;
	private String loanType;
	private long loanAmount;
	private String loanTenure;
	
	private long paidAmount;
	private long remainingAmount;
	private String bankName;
	

}
