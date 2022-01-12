package com.example.jobportal.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "jobs")
public class Jobs {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "JobId")
    private Integer jobid;

    @Column(name = "Title")
    private String title;

    @Column(name = "Grade")
    private String grade;

    @Column(name = "Description")
    private String description;

    @Column(name = "Role")
    private String role;

    @Column(name = "ApplyByDate")
    private Date applybydate;

    public Integer getJobid() {
        return jobid;
    }

    public void setJobid(Integer jobid) {
        this.jobid = jobid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getApplybydate() {
        return applybydate;
    }

    public void setApplybydate(Date applybydate) {
        this.applybydate = applybydate;
    }

}
