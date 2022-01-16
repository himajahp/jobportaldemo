package com.example.jobportal.service;

import com.example.jobportal.model.Job;
import com.example.jobportal.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    //get all jobs
    public List<Job> getAllJobs() { return this.jobRepository.findAll(); }

    //get job by id
    public Job getJobById(int job_id) {
        Optional<Job> optional = jobRepository.findById(job_id);
        Job job;
        if (optional.isPresent()) {
            job = optional.get();
        } else {
            throw new RuntimeException(" Job not found for id :: " + job_id);
        }
        return job;
    }

    //get job by name
    public Job getJobByName(String title) {
        Job job = this.jobRepository.getJobByTitle(title);
        return job;
    }

    //add new job
    public void addNewJob(Job job) {
        this.jobRepository.save(job);
    }

    //update job
    public void updateJob(Job job) {
        Job job1 = this.jobRepository.getById(job.getJob_id());
        job1.setDescription(job.getDescription());
        job1.setJob_role(job.getJob_role());
        job1.setJob_id(job.getJob_id());;
        job1.setTitle(job.getTitle());
        job1.setApply_by_date(job.getApply_by_date());
    }

    //delete job
    public void deleteJob(int id) {
        this.jobRepository.deleteById(id);
    }
}
