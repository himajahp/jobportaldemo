package com.example.jobportal.repository;

import com.example.jobportal.model.UserJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJobRepository extends JpaRepository<UserJob, Integer> {

    @Query("Select user_id, job_id from UserJob uj where uj.job_id = :job_id order by uj.job_id")
    Object[] findAllUsersByJobId(@Param("job_id") int job_id);
}
