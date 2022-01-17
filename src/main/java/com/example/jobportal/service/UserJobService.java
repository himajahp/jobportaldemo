package com.example.jobportal.service;

import com.example.jobportal.repository.UserJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserJobService {
    @Autowired
    private UserJobRepository userJobRepository;

    //search for users who applied for a job
    public Object[] getUserListAppliedToAJob(int job_id) {
        return this.userJobRepository.findAllUsersByJobId(job_id);
    }
}
