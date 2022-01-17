package com.example.jobportal.repository;

import com.example.jobportal.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

    @Query("Select j from Job j where j.title = :title")
    Job getJobByTitle(@Param("title") String title);

    @Query("Select m from Job m where m.company = :company")
    List<Job> getJobByCompany(@Param("company") String company);
}
