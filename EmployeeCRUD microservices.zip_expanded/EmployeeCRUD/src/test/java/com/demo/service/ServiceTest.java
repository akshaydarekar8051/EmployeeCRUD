package com.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.dao.EmployeeRepository;
import com.demo.model.Employee;
import com.demo.service.EmployeeServiceImpl;

@SpringBootTest
public class ServiceTest {

	@InjectMocks
	EmployeeServiceImpl employeServiceImpl ;
	
	@Mock
	EmployeeRepository employeeRepository ;
	
	@Test
	public void saveEmployeeTest()
	{
	Employee employee = new Employee(5,"Akshay","Darekar","akshaydarekar24@gmail.com",26);
	when(employeeRepository.save(employee)).thenReturn(employee);
	assertEquals(employee,employeServiceImpl.save(employee));
	}
	
	@Test
	public void getAllEmployeeTest()
	{
	Employee employee1 = new Employee(1,"raj","verma","raj.verma@emagine.com",35);
	Employee employee2 = new Employee(2,"vaibhav","telang","v.telang@futureready.com",29);
	Employee employee3 = new Employee(3,"ketan","bahadur","k.bahadur24@infonext.com",32);
	Employee employee4 = new Employee(4,"abhishek","raj","abhi.raj@softsol.com",30);;
	List<Employee> actualEmployeesList = new ArrayList<Employee>(); 
	when(employeeRepository.findAll()).thenReturn(actualEmployeesList);
	List<Employee> expectedEmployeeList= employeServiceImpl.getAllEmployee();
      assertEquals(expectedEmployeeList, actualEmployeesList);
	}

	
	

}
