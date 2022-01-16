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

    //get all employees
    public List<Employee> getAllEmployees() { return this.employeeRepository.findAll(); }

    //add single employee
    public void saveEmployee(Employee employee) { employeeRepository.save(employee); }

    //add list of employees
    public void saveEmployees(List<Employee> employees) { this.employeeRepository.saveAll(employees); }

    //delete employee by id
    public void deleteEmployeeById(int id) { this.employeeRepository.deleteById(id); }

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
