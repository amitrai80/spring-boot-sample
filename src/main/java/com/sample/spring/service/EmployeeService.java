package com.sample.spring.service;

import com.sample.spring.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeService  extends CrudRepository<Employee, Integer> {

    Iterable<Employee> findByFirstNameAndLastName(String fristName, String lastName);
    Iterable<Employee> findByFirstName(String firstName);
    Iterable<Employee> findByLastName(String lastName);
}
