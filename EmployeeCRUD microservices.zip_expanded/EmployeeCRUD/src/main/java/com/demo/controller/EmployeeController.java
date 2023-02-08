package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Employee;
import com.demo.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	

	@GetMapping("/allEmployee")
	public List<Employee> getAllEmployee()
	{
		List<Employee> empList= employeeServiceImpl.getAllEmployee();
	    return empList;
	}
	
	@GetMapping("{emp_id}") //1
	public Employee getEmployeeById(@PathVariable("emp_id") int emp_id)
	{
		 Employee OneEmployee= employeeServiceImpl.getEmployeeById(emp_id);
		 return OneEmployee;
	}
	
	@PostMapping("/save/employee")
	public Employee saveEmployee(@RequestBody Employee employee)
	{
		 Employee savedEmployee= employeeServiceImpl.save(employee);
		 return savedEmployee;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmployeeById(@PathVariable("id") int id)
	{
		employeeServiceImpl.delete(id);
		System.out.println("Employee is deleted ....");
	}
	
	@PutMapping("/update")
	public void updateEmployee(@RequestBody Employee employee)
	{
		employeeServiceImpl.updateEmployee(employee);
	}
	
	
}
