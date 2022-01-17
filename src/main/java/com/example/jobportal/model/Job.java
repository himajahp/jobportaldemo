package com.example.jobportal.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Integer job_id;

    @Column(name = "title")
    private String title;

    @Column(name = "grade")
    private String grade;

    @Column(name = "description")
    private String description;

    @Column(name = "job_role")
    private String job_role;

    @Column(name = "apply_by_date")
    private Date apply_by_date;

    @Column(name = "company")
    private String company;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getJob_id() {
        return job_id;
    }

    public void setJob_id(Integer job_id) {
        this.job_id = job_id;
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

    public String getJob_role() {
        return job_role;
    }

    public void setJob_role(String job_role) {
        this.job_role = job_role;
    }

    public Date getApply_by_date() {
        return apply_by_date;
    }

    public void setApply_by_date(Date apply_by_date) {
        this.apply_by_date = apply_by_date;
    }
}
