package com.example.jobportal.controller;

import com.example.jobportal.model.Job;
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
    public String getAllJobs(Model model) {
        List<Job> jobs = this.jobService.getAllJobs();
        model.addAttribute("job", jobs);
        return "AllJobs";
    }

    // job by id
    @GetMapping("/getjobbyid/{id}")
    public String getJobById(@PathVariable( value = "id") int id, Model model) {
        Job job = this.jobService.getJobById(id);
        model.addAttribute("job", job);
        return "Job";
    }

    // job by name
    @GetMapping("/getjobbyname/{title}")
    public String getJobById(@PathVariable( value = "title") String title, Model model) {
        Job job = this.jobService.getJobByName(title);
        model.addAttribute("job", job);
        return "Job";
    }

    // add new job
    @PostMapping(path = "/addjob",
            consumes = "application/json",
            produces = "application/json")
    public List<Job> addNewJob(@RequestBody Job job) {
        this.jobService.addNewJob(job);
        return this.jobService.getAllJobs();
    }

    // edit a job
    @PutMapping(path = "/updatejob")
    public Job updateJob(@RequestBody Job job, Model model) {
        this.jobService.updateJob(job);
        return this.jobService.getJobById(job.getJob_id());
    }

    // delete job
    @DeleteMapping(path = "/deletejob/{id}")
    public List<Job> deleteJob(@PathVariable (value = "id") int id) {
        this.jobService.deleteJob(id);
        return this.jobService.getAllJobs();
    }

}
