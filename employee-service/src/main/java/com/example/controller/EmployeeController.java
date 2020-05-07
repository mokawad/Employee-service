package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping
	private ResponseEntity<Employee> save(@RequestBody Employee employee) {
		return new ResponseEntity<>(service.save(employee), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<Optional<Employee>> getById(@PathVariable long id) {
		return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
	}
	
	@GetMapping
	private ResponseEntity<List<Employee>> getAll() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}
}
