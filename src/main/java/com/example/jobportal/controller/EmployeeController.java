package com.example.jobportal.controller;

import com.example.jobportal.model.Employee;
import com.example.jobportal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // get list of all employees
    @GetMapping("/admin/getEmployees")
    public List<Employee> getListOfEmployees() {
        return this.employeeService.getAllEmployees();
    }

    // Add new employee
    @PostMapping( path = "/admin/addEmployee",
            consumes = "application/json",
            produces = "application/json")
    public List<Employee> saveEmployee(@RequestBody Employee employee) {
        // save employee to database
        this.employeeService.saveEmployee(employee);
        return this.employeeService.getAllEmployees();
    }

    // Add new employees
    @PostMapping( path = "/admin/addEmployees",
            consumes = "application/json",
            produces = "application/json")
    public List<Employee> saveEmployees(@RequestBody List<Employee> employees) {
        // save employee to database
        this.employeeService.saveEmployees(employees);
        return this.employeeService.getAllEmployees();
    }

    //Delete an employee
    @DeleteMapping("/admin/deleteEmployee/{id}")
    public List<Employee> deleteEmployee(@PathVariable (value = "id") int id) {
        this.employeeService.deleteEmployeeById(id);
        return this.employeeService.getAllEmployees();
    }

    // update employee
    @PutMapping("/admin/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        this.employeeService.updateEmployeeDetails(employee);
        return this.employeeService.getEmployeeById(employee.getEmp_id());
    }

}
