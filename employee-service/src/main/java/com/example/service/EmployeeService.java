package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;


@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	public Employee save(Employee employee) {  //create or save  ==> same
		return repository.save(employee);
	}
	
	public Optional<Employee> getById(long id) {
		return repository.findById(id);
	}
	
	//java 1.8
	/**public List<Employee> getAll() {
		List<Employee> employeeList = new ArrayList<>();
		repository.findAll().forEach(e -> {
			employeeList.add(e);
		});
		return employeeList;
	}
	**/
	
	// java 1.7 or older
	public List<Employee> getAll() {
		List<Employee> employeeList = new ArrayList<>(); // empty list of employee
		Iterable<Employee> empList = repository.findAll(); // getting from database
		// convert iterable  to list//
		for(Employee emp: empList) {
			employeeList.add(emp);
		}
		return employeeList;
	}

}
