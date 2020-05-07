package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

public class EmployeeServiceTest {

	@InjectMocks
	private EmployeeService service;
	
	@Mock
	private EmployeeRepository repository;
	private Employee employee;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		employee= create();
	}
	
	@Test
	public void createSuccess() {
		//Employee employee = create();
		Mockito.when(repository.save(employee)).thenReturn(employee);
		Employee actualResult = service.save(employee);
		Assertions.assertEquals(actualResult.getDesignation(), employee.getDesignation());
	}
	
	@Test
	public void findByIdSuccess() {
		Optional<Employee> optionEMP = Optional.of(employee); 
		Mockito.when(repository.findById(employee.getId())).thenReturn(optionEMP);
		Optional<Employee> actualResult = service.getById(employee.getId());
		Assertions.assertEquals(optionEMP.get().getName(), actualResult.get().getName());
		Assertions.assertEquals(optionEMP.get().getId(), actualResult.get().getId());
		Assertions.assertEquals(optionEMP.get().getDesignation(), actualResult.get().getDesignation());
	}
	
	@Test
	public void getallSuccess() {
		List<Employee> employeelist = new ArrayList<>();
		employeelist.add(employee);
		Mockito.when(repository.findAll()).thenReturn(employeelist);
		List<Employee> actualResult = service.getAll();
		Assertions.assertEquals(employeelist.size(), actualResult.size());
		Assertions.assertEquals(employeelist.get(0).getName(), actualResult.get(0).getName());
	}
	
	
	private Employee create() {
		Employee employee = new Employee();
		employee.setId(1l);
		employee.setName("Jhonny");
		employee.setSalary(10000D);
		employee.setDesignation("Developer");
		return employee;
	}
	
}
