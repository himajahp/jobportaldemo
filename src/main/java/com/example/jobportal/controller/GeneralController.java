package com.example.jobportal.controller;

import com.example.jobportal.model.User;
import com.example.jobportal.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GeneralController {

    @Autowired
    private GeneralService generalService;

    // landing page
    @GetMapping("/")
    public String viewHomePage() {
        return this.generalService.viewHomePage();
    }

    // profile details
    @GetMapping(path = "/profile",
            consumes = "application/json",
            produces = "application/json")
    public User profile(@RequestBody int user_id) {
        return this.generalService.profile(user_id);
    }

    // edit profile details
    // the path will be different based on user, recruiter and admin
    @PutMapping(path = "/editProfile",
            consumes = "application/json",
            produces = "application/json")
    public User editProfile(@RequestBody User user) {
        this.generalService.editProfile(user);
        return this.generalService.profile(user.getUser_id());
    }

}
