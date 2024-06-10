package com.cjc.homeloan.employeeservice.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.homeloan.employeeservice.app.model.Employee;
import com.cjc.homeloan.employeeservice.app.repository.EmployeeRepository;
import com.cjc.homeloan.employeeservice.app.servicei.EmployeeServiceI;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI{
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public void saveEmployee(Employee e) {
		employeeRepository.save(e);
		
	}

	@Override
	public Employee findByUsernameAndPassword(String username, String password) {
		return employeeRepository.findByUsernameAndPassword(username,password);
		
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

}
