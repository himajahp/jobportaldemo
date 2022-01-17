package com.example.jobportal.service;

import com.example.jobportal.model.Admin;
import com.example.jobportal.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    // land on the home page
    public String getAdminHomePage() {
        return "Admin Home Page";
    }

    // add new admin
    public void saveAdmin(Admin admin) { this.adminRepository.save(admin); }

    //get all admins
    public List<Admin> getAllAdmins() { return this.adminRepository.findAll(); }
}
