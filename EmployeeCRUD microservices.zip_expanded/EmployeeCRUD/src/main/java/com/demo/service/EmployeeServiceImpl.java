package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.EmployeeRepository;
import com.demo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeService{

	//Autowire repository interface
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(emp1 ->list.add(emp1));
		return list;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee employee= employeeRepository.findById(id).get();
		return employee;
	}

	@Override
	public Employee save(Employee employee) {
		 Employee savedemployee= employeeRepository.save(employee);
		return savedemployee;
	}

	@Override
	public void delete(int id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

}
