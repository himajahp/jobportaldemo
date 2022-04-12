package com.example.jobportal.controller;

import com.example.jobportal.model.Admin;
import com.example.jobportal.model.Employee;
import com.example.jobportal.model.User;
import com.example.jobportal.service.AdminService;
import com.example.jobportal.service.EmployeeService;
import com.example.jobportal.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    // land on the home page
    @GetMapping("/admin/adminhomepage")
    public String gethomepage() { return adminService.getAdminHomePage(); }

    // add new admin
    @PostMapping(path = "/admin/addnewadmin",
            consumes = "application/json",
            produces = "application/json")
    public List<Admin> saveAdmin(@RequestBody Admin admin) {
        // save admin to database
        this.adminService.saveAdmin(admin);
        return this.adminService.getAllAdmins();
    }

    // ---------- recruiter ---------- //

    // get list of all employees/recruiter
    @GetMapping("/admin/getEmployees")
    public List<Employee> getListOfEmployees() {
        return this.employeeService.getAllEmployees();
    }

    // get employee by id
    @GetMapping("/admin/getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable  (value = "id") int id) {
        return this.employeeService.getEmployeeById(id);
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

    // update employee
    @PutMapping("/admin/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        this.employeeService.updateEmployeeDetails(employee);
        return this.employeeService.getEmployeeById(employee.getEmp_id());
    }

    //Delete an employee
    @DeleteMapping("/admin/deleteEmployee/{id}")
    public List<Employee> deleteEmployee(@PathVariable (value = "id") int id) {
        this.employeeService.deleteEmployeeById(id);
        return this.employeeService.getAllEmployees();
    }

    // ---------- user ---------- //

    // get list of all users
    @GetMapping("/admin/getUsers")
    public List<User> getListOfUser() {
        return this.userDetailsService.getAllUsers();
    }

    // get user by id
    @GetMapping("/admin/getUserById/{id}")
    public User getUser(@PathVariable (value = "id") int id) {
        return this.userDetailsService.getUserById(id);
    }

    // add user
    @PostMapping( path = "/addUser",
            consumes = "application/json",
            produces = "application/json")
    public List<User> saveUser(@RequestBody User user) {
        // save user to database
        this.userDetailsService.saveUser(user);
        return this.userDetailsService.getAllUsers();
    }

    // edit user
    @PatchMapping("/admin/updateUser")
    public User updateUser(@RequestBody User user) {
        return this.userDetailsService.updateUserDetailsByAdmin(user);
    }

    // delete user
    @DeleteMapping(path = "/admin/removeuser/{id}")
    public List<User> removeUser(@PathVariable (value = "id") int id ) {
        this.userDetailsService.removeUser(id);
        return this.userDetailsService.getAllUsers();
    }
}
