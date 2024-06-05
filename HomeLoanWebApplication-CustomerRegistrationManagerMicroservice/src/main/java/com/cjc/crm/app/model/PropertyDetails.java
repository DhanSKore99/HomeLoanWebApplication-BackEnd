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
public class PropertyDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int propertyId;
	private String propertyAddress;
	private String propertyName;
	private String propertyStatus;
	private double propertyAgreementAmount;


}
