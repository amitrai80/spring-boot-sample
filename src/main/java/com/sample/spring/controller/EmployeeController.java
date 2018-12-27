package com.sample.spring.controller;

import com.sample.spring.model.Employee;
import com.sample.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


}
