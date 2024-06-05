package com.cjc.crm.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.crm.app.model.IncomeDetails;


@Repository
public interface IncomeDetailsRepository extends JpaRepository<IncomeDetails, Integer>{

}
