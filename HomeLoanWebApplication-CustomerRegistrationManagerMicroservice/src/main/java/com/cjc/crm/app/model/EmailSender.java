package com.cjc.crm.app.model;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailSender {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int emailSenderId;
	@Value("$spring.mail.username")
	private String fromEmail;
	private String toEmail;
	private String subject;
	private String textMessage;

	
}