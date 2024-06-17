package com.cjc.homeloan.employeeservice.app.model;

import com.cjc.homeloan.employeeservice.app.enums.UserType;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
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
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empid;
	private String empname;
	private int age;
	private String username;
	private String password;
	@Enumerated()
	private UserType usertype;

}
