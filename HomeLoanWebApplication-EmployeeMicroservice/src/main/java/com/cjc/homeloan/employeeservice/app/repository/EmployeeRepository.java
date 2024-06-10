package com.cjc.homeloan.employeeservice.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.homeloan.employeeservice.app.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	Employee findByUsernameAndPassword(String username, String password);

	

}
