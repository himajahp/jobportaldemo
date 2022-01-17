package com.example.jobportal.controller;

import com.example.jobportal.model.User;
import com.example.jobportal.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    // get list of all users
    @GetMapping("/admin/getUsers")
    public List<User> getListOfUser() {
        return this.userDetailsService.getAllUsers();
    }

    // Add new user
    @PostMapping( path = "/addUser",
            consumes = "application/json",
            produces = "application/json")
    public List<User> saveUser(@RequestBody User user) {
        // save user to database
        this.userDetailsService.saveUser(user);
        return this.userDetailsService.getAllUsers();
    }

}
