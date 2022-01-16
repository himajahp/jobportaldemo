package com.example.jobportal.service;

import org.springframework.stereotype.Service;


@Service
public class AdminService {

    // land on the home page
    public String getAdminHomePage() {
        return "Admin Home Page";
    }

}
