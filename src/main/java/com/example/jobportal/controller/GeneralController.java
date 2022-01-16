package com.example.jobportal.controller;

import com.example.jobportal.model.Employee;
import com.example.jobportal.model.User;
import com.example.jobportal.service.GeneralService;
import com.example.jobportal.service.JobService;
import com.example.jobportal.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class GeneralController {

    @Autowired
    private GeneralService generalService;
    @Autowired
    private JobService jobService;

    // landing page
    @GetMapping("/")
    public String viewHomePage() {
        return this.generalService.viewHomePage();
    }

    // profile details
    @GetMapping("/profile")
    public String profile() {
        return this.generalService.profile();
    }

    // edit profile details
    // the path will be different based on user, recruiter and admin
    @PutMapping("/editProfile")
    public String editProfile(User user) {
        this.generalService.editProfile(user);
        return this.generalService.profile();
    }

}
