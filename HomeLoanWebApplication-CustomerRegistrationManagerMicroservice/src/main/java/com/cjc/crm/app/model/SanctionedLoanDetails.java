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
public class SanctionedLoanDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sanctionedLoanId;
	private long sanctionedLoanAmount;
	private int sanctionedTenure;
	private long emi;
	private long disbursedAmount;
	private String customerName;
	private int customerId;

	}
