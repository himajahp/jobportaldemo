package com.example.jobportal.controller;

import com.example.jobportal.model.Employee;
import com.example.jobportal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // landing page
    @GetMapping("/")
    public String viewHomePage() {
        return this.employeeService.viewHomePage();
    }

    @GetMapping("/getEmployees")
    public List<Employee> getListOfEmployees() {
        return this.employeeService.getAllEmployees();
    }


    // Add new employee
    @PostMapping( path = "/admin/addEmployee",
            consumes = "application/json",
            produces = "application/json")
    public List<Employee> saveEmployee(@RequestBody Employee employee) {
        // save employee to database
        employeeService.saveEmployee(employee);
        return this.employeeService.getAllEmployees();
    }

    // Add new employees
    @PostMapping( path = "/admin/addEmployees",
            consumes = "application/json",
            produces = "application/json")
    public List<Employee> saveEmployees(@RequestBody List<Employee> employees) {
        // save employee to database
        employeeService.saveEmployees(employees);
        return this.employeeService.getAllEmployees();
    }

    //Delete an employee
    @DeleteMapping("/admin/deleteEmployee/{id}")
    public List<Employee> deleteEmployee(@PathVariable (value = "id") int id) {
        this.employeeService.deleteEmployeeById(id);
        return this.employeeService.getAllEmployees();
    }

    @PutMapping("/admin/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        this.employeeService.updateEmployeeDetails(employee);
        return this.employeeService.getEmployeeById(employee.getEmp_id());
    }


    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {

        // get employee from the service
        Employee employee = employeeService.getEmployeeById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        return "update_employee";
    }



    @GetMapping("/jobsearch")
    public String showLandingPage() {
        return "redirect: /jobsearchelp";
    }

    @GetMapping("/jobsearchelp")
    public String landingPage() {
        return "JobsLandingPage";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }
}
