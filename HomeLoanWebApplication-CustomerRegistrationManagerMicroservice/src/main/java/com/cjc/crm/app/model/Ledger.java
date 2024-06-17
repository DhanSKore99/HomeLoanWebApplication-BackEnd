package com.cjc.crm.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ledger {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ledgerId;
	private String ledgerCreatedDate ;
	private double totalLoanAmount ;
	private double payableAmountwithInterest;
	private int tenure;
	private double monthlyEMI ;
	private double amountPaidtillDate;
	private double remainingAmount;
	private String nextEmiDatestart ;
	private String nextEmiDateEnd ;
	private int defaulterCount ;
	private String previousEmitStatus ;
	private String currentMonthEmiStatus ;
	private String loanEndDate ;
	private String loanStatus ;
}
