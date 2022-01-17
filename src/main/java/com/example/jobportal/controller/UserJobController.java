package com.example.jobportal.controller;

import com.example.jobportal.service.UserJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserJobController {

    @Autowired
    private UserJobService userJobService;

    //search for users who applied for a job
    @GetMapping("/appliedUsers/{job_id}")
    public Object[] getUserListAppliedToAJob(@PathVariable(value = "job_id") int job_id) {
        return this.userJobService.getUserListAppliedToAJob(job_id);
    }
}
