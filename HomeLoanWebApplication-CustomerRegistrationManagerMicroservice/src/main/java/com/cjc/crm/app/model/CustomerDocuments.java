package com.cjc.crm.app.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerDocuments implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int documentId;
	
	@Lob
	@Column(length=700000)
	private byte[] panCard;
	
	@Lob
	@Column(length=700000)
	private byte[] photo;
	
	@Lob
	@Column(length=700000)
	private byte[] adharCard;
	
	@Lob
	@Column(length=700000)
	private byte[] salarySlips;
	
	@Lob
	@Column(length=700000)
	private byte[] bankStatement;
	
	@Lob
	@Column(length=700000)
	private byte[] addressProof;


}
