package com.cjc.homeloan.employeeservice.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class HomeLoanWebApplicationEmployeeMicroservice2Application {

	public static void main(String[] args) {
		SpringApplication.run(HomeLoanWebApplicationEmployeeMicroservice2Application.class, args);
	}

}
