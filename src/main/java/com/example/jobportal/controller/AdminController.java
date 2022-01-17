package com.example.jobportal.controller;

import com.example.jobportal.model.Admin;
import com.example.jobportal.service.AdminService;
import com.example.jobportal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private EmployeeService employeeService;

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

}
