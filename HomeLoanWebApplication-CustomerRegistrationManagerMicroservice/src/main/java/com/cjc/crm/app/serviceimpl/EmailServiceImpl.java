package com.cjc.crm.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cjc.crm.app.model.CustomerDetails;
import com.cjc.crm.app.servicei.EmailServiceI;

@Service
public class EmailServiceImpl implements EmailServiceI{
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	public void sendEmail(String to) {
		
		String subject="HomeLoan application";
		
		String text1= "Hi.. Your Loan Application is submitted successfully. We will review your application"
				+ "and we will get back to you. Thank You." + "\n" + "Regards," + "\n" + "Team CRM";
		
		
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("dhanashrighotkar99gmail.com");
		msg.setTo(to);
		msg.setSubject(subject);
		msg.setText(text1);
		
		javaMailSender.send(msg);
		
	}
	
	public void sendUpdates(String to) {
		
		String subject="HomeLoan application";
		
		
		
		String text2 = "Hi.. Your Loan Application is Updated successfully. Thank You." + "\n" + "Regards," + "\n" + "Team CRM";
		
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("dhanashrighotkar99gmail.com");
		msg.setTo(to);
		msg.setSubject(subject);
		msg.setText(text2);
		
		javaMailSender.send(msg);
		
	}

}
