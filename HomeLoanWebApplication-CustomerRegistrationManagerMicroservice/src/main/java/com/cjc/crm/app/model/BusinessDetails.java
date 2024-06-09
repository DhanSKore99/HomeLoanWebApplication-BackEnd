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
public class BusinessDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int businessDetailsId;
	private String businessName;
	private String businessAddress;
	private String businessContactNumber;
	private String businessEmailId;

}
