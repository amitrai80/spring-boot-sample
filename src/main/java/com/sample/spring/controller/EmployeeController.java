package com.sample.spring.controller;

import com.sample.spring.model.Employee;
import com.sample.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee create(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @GetMapping("/employee")
    public Iterable<Employee> read(){
        return employeeService.findAll();
    }

    @PutMapping("/employee")
    public Employee update(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/employee/{id}")
    public void delete(@PathVariable Integer id){
        employeeService.deleteById(id);
    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> findById(@PathVariable Integer id){
        return employeeService.findById(id);
    }

    @GetMapping("/employee/search")
    public Iterable<Employee> findByQuery(@RequestParam(value = "first", required = false) String firstName, @RequestParam(value = "last", required = false) String lastName) {
        if (!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)){
            return employeeService.findByFirstNameAndLastName(firstName, lastName);
        }else if(!StringUtils.isEmpty(firstName)){
            return employeeService.findByFirstName(firstName);
        }else if (!StringUtils.isEmpty(lastName)){
            return employeeService.findByLastName(lastName);
        }else{
            return employeeService.findAll();
        }

    }
}
