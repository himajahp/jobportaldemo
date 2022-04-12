package com.example.jobportal.controller;

import com.example.jobportal.model.Employee;
import com.example.jobportal.model.Job;
import com.example.jobportal.service.EmployeeService;
import com.example.jobportal.service.JobService;
import com.example.jobportal.service.UserJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;
import java.util.List;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JobService jobService;

    @Autowired
    private UserJobService userJobService;

    // add a job
    @PostMapping(path = "/addjob",
            consumes = "application/json",
            produces = "application/json")
    public Job addNewJob(@RequestBody Job job) {
        return this.jobService.addNewJob(job);
    }

    // edit a job
    @PutMapping(path = "/updatejob")
    public Job updateJob(@RequestBody Job job, Model model) {
        return this.jobService.updateJob(job);
    }

    // delete job
    @DeleteMapping(path = "/deletejob/{id}")
    public List<Job> deleteJob(@PathVariable (value = "id") int id) {
        this.jobService.deleteJob(id);
        return this.jobService.getAllJobs();
    }

    //search for users who applied for a job
    @GetMapping("/appliedUsers/{job_id}")
    public Object[] getUserListAppliedToAJob(@PathVariable(value = "job_id") int job_id) {
        return this.userJobService.getUserListAppliedToAJob(job_id);
    }

    // send email
    @RequestMapping(value = "/sendemail")
    public String sendEmail() throws AddressException, MessagingException, IOException {
        this.employeeService.sendmail();
        return "Email sent successfully";
    }
}
