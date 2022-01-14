package com.example.jobportal.service;

import com.example.jobportal.model.Employee;
import com.example.jobportal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public String viewHomePage() {
        return "Welcome to the Job Portal!";
    }

    //get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    //add single employee
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    //add list of employees
    public void saveEmployees(List<Employee> employees) {
        this.employeeRepository.saveAll(employees);
    }

    public Employee getEmployeeById(int id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return employee;
    }

    public void deleteEmployeeById(int id) { this.employeeRepository.deleteById(id); }

    //update employee details
    public Employee updateEmployeeDetails(Employee employee) {
        Employee emp = employeeRepository.findById(employee.getEmp_id()).orElse(null);
        emp.setEmp_id(employee.getEmp_id());
        emp.setFirst_name(employee.getFirst_name());
        emp.setLast_name(employee.getLast_name());
        emp.setEmail(employee.getEmail());
        emp.setRole(employee.getRole());
        return this.employeeRepository.save(emp);
    }
}
