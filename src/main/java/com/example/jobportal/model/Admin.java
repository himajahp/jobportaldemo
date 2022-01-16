package com.example.jobportal.model;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue
    @Column(name = "admin_id")
    private int admin_id;

    @Column(name = "admin_fname")
    private String admin_fname;

    @Column(name = "admin_lname")
    private String admin_lname;

    @Column(name = "admin_email")
    private String admin_email;

    @Column(name = "role")
    private String role;

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_fname() {
        return admin_fname;
    }

    public void setAdmin_fname(String admin_fname) {
        this.admin_fname = admin_fname;
    }

    public String getAdmin_lname() {
        return admin_lname;
    }

    public void setAdmin_lname(String admin_lname) {
        this.admin_lname = admin_lname;
    }

    public String getAdmin_email() {
        return admin_email;
    }

    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
