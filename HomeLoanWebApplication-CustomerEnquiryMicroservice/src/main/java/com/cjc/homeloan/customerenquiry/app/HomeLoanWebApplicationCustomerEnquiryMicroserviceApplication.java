package com.cjc.homeloan.customerenquiry.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class HomeLoanWebApplicationCustomerEnquiryMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeLoanWebApplicationCustomerEnquiryMicroserviceApplication.class, args);
	}

}
