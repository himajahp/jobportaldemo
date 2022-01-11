package com.example.jobportal.demojobportal;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// Import the above-defined classes to use the properties of those classes
import com.example.jobportal.demojobportal.Employees;
import com.example.jobportal.demojobportal.EmployeeDAO;
import com.example.jobportal.demojobportal.Employee;

// Creating the REST controller

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDao;

    // Implementing a GET method to get the list of all the employees
    @GetMapping(
            path = "/",
            produces = "application/json")

    public Employees getEmployees()
    {
        return employeeDao.getAllEmployees();
    }
    // Create a POST method to add an employee to the list
    @PostMapping(
            path = "/",
            consumes = "application/json",
            produces = "application/json")

    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        // Creating an ID of an employee from the number of employees
        Integer id
                = employeeDao
                .getAllEmployees()
                .getEmployeeList()
                .size()
                + 1;

        employee.setId(id);

        employeeDao.addEmployee(employee);

        URI location
                = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/change/{id}")
    public void changeEmployee(@PathVariable int id, @RequestBody Employee employeebody) {
        employeeDao.changeEmployee(id, employeebody);
    }

    @DeleteMapping("delete/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeDao.deleteEmployeeRecord(id);
    }
}

