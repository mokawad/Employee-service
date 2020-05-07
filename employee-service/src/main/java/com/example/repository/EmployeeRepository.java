package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.model.*;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
