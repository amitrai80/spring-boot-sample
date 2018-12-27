package com.sample.spring.service;

import com.sample.spring.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeService  extends CrudRepository<Employee, Integer> {
}
