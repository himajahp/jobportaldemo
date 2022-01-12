package com.example.jobportal.controller;

import com.example.jobportal.model.Employee;
import com.example.jobportal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // home page
    @GetMapping("/")
    public String viewHomePage() {
        return this.employeeService.viewHomePage();
    }

    @GetMapping("/getEmployees")
    public List<Employee> getListOfEmployees() {
        return this.employeeService.getAllEmployees();
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

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        // save employee to database
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model) {

        // get employee from the service
        Employee employee = employeeService.getEmployeeById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") int id) {

        // call delete employee method
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }
}
