package com.cjc.homeloan.employeeservice.app.servicei;

import java.util.List;

import com.cjc.homeloan.employeeservice.app.model.Employee;

public interface EmployeeServiceI {

	void saveEmployee(Employee e);

	Employee findByUsernameAndPassword(String username, String password);

	List<Employee> getAllEmployee();

}
