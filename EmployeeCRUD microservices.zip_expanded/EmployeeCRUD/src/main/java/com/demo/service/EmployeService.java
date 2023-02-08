package com.demo.service;

import java.util.List;

import com.demo.model.Employee;

public interface EmployeService {

	// getting all the employees from DB
	public List<Employee> getAllEmployee();
	
	//getting specific record by using id
	public Employee getEmployeeById(int id);
	
	//saving specific employee into DB
	public Employee save(Employee employee);
	
	//deleting specific employee based on id
	public void delete(int id );
	
	//update particular employee
	public void updateEmployee(Employee employee);
}
