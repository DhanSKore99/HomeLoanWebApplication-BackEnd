package com.cjc.homeloan.customerenquiry.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.homeloan.customerenquiry.app.model.Enquiry;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Integer>{

	Enquiry findByEnquiryId(int enquiryId);

}
