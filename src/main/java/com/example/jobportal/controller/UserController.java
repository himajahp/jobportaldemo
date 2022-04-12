package com.example.jobportal.controller;

import com.example.jobportal.model.Job;
import com.example.jobportal.model.User;
import com.example.jobportal.model.UserJob;
import com.example.jobportal.service.JobService;
import com.example.jobportal.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private JobService jobService;

    // Add new user or self registration process
    @PostMapping( path = "/addUser",
            consumes = "application/json",
            produces = "application/json")
    public List<User> saveUser(@RequestBody User user) {
        // save user to database
        this.userDetailsService.saveUser(user);
        return this.userDetailsService.getAllUsers();
    }
    // view all jobs
    @GetMapping("/alljobs")
    public List<Job> getAllJobs(Model model) {
        List<Job> jobs = this.jobService.getAllJobs();
        model.addAttribute("job", jobs);
        return jobs;
    }

    // search job by title
    @GetMapping(path = "/getjobbyname/{title}")
    public Job getJobById(@PathVariable( value = "title") String title, Model model) {
        Job job = this.jobService.getJobByName(title);
        model.addAttribute("job", job);
        return job;
    }

    // search job by company name
    @GetMapping(path = "/getjobbycompany/{company}")
    public List<Job> getJobByCompany(@PathVariable(value = "company") String company) {
        return this.jobService.getJobByCompany(company);
    }

    // search job by id
    @GetMapping(path = "/getjobbyid/{id}")
    public Job getJobById(@PathVariable( value = "id") int id, Model model) {
        Job job = this.jobService.getJobById(id);
        model.addAttribute("job", job);
        return job;
    }

    // user updates/edits own profile
    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user) {
        return this.userDetailsService.updateUserDetails(user);
    }

    // apply for job
    @PostMapping(path = "/applyforjob",
            consumes = "application/json",
            produces = "application/json")
    public List<Job> applyForJob(@RequestBody UserJob userJob) {
        this.jobService.applyForJob(userJob);
        return this.jobService.getAllJobs();
    }
}
