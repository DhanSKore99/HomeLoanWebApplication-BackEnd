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
public class CustomerBankDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bankDetailsId;
	private String bankName;
	private Long bankAccountNumber;
	private String ifscCode;


}
