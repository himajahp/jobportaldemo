package com.example.jobportal.service;

import com.example.jobportal.model.User;
import com.example.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GeneralService {

    @Autowired
    private UserRepository userRepository;

    //landing page
    public String viewHomePage() {
        return "Hello! Welcome to the Job Portal!";
    }

    // profile details
    public User profile(int user_id) {
        User user1 = this.userRepository.findById(user_id).orElse(null);
        return user1;
    }

    //edit user profile
    public User editProfile(User user) {
        User user1 = this.userRepository.findById(user.getUser_id()).orElse(null);
        user1.setUser_fname(user.getUser_fname());
        user1.setUser_lname((user.getUser_lname()));
        user1.setUser_password(user.getUser_password());
        return this.userRepository.save(user1);
    }

}