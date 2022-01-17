package com.example.jobportal.model;

import javax.persistence.*;

@Entity
@Table(name = "user_job")
public class UserJob {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "user_id")
    int user_id;
    @Column(name = "job_id")
    int job_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }
}
