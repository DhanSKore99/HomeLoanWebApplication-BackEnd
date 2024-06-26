package com.cjc.crm.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.crm.app.model.CustomerDetails;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Integer> {

	CustomerDetails findByCustomerId(int customerId);




	CustomerDetails findByUsernameAndPassword(String username, String password);
	

}
