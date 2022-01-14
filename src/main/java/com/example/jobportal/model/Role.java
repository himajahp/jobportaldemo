package com.example.jobportal.model;

import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer role_id;
    private String role_name;

    public Integer getRole_id() { return role_id; }

    public void setRole_id(Integer role_id) { this.role_id = role_id; }

    public String getRole_name() { return role_name; }

    public void setRole_name(String role_name) { this.role_name = role_name; }
}
