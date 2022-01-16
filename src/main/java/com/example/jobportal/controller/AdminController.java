package com.example.jobportal.controller;

import com.example.jobportal.service.AdminService;
import com.example.jobportal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private EmployeeService employeeService;

    // land on the home page
    @GetMapping("/adminhomepage")
    public String gethomepage() { return adminService.getAdminHomePage(); }

}
