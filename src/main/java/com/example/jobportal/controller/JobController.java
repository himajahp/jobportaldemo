package com.example.jobportal.controller;

import com.example.jobportal.model.Job;
import com.example.jobportal.model.UserJob;
import com.example.jobportal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/alljobs")
    public List<Job> getAllJobs(Model model) {
        List<Job> jobs = this.jobService.getAllJobs();
        model.addAttribute("job", jobs);
        return jobs;
    }

    // job by id
    @GetMapping(path = "/getjobbyid/{id}")
    public Job getJobById(@PathVariable( value = "id") int id, Model model) {
        Job job = this.jobService.getJobById(id);
        model.addAttribute("job", job);
        return job;
    }

    // job by title
    @GetMapping(path = "/getjobbyname/{title}")
    public Job getJobById(@PathVariable( value = "title") String title, Model model) {
        Job job = this.jobService.getJobByName(title);
        model.addAttribute("job", job);
        return job;
    }

    // job by company name
    @GetMapping(path = "/getjobbycompany/{company}")
    public List<Job> getJobByCompany(@PathVariable(value = "company") String company) {
        return this.jobService.getJobByCompany(company);
    }

    // add new job
    @PostMapping(path = "/addjob",
            consumes = "application/json",
            produces = "application/json")
    public List<Job> addNewJob(@RequestBody Job job) {
        this.jobService.addNewJob(job);
        return this.jobService.getAllJobs();
    }

    // apply for job
    @PostMapping(path = "/applyforjob",
            consumes = "application/json",
            produces = "application/json")
    public List<Job> applyForJob(@RequestBody UserJob userJob) {
        this.jobService.applyForJob(userJob);
        return this.jobService.getAllJobs();
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

}
