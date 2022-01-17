package com.example.jobportal.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    @Column(name = "user_fname")
    private String user_fname;
    @Column(name = "user_lname")
    private String user_lname;
    private String user_password;
    private boolean enabled;
    private String roles;
    private String email;


//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "users_roles", joinColumns = @JoinColumn (name = "user_id"), inverseJoinColumns = @JoinColumn (name = "role_id"))
//    private Set<Role> roles = new HashSet<>();

    public int getUser_id() { return user_id; }

    public void setUser_id(int user_id) { this.user_id = user_id; }

    public String getUser_fname() { return user_fname; }

    public void setUser_fname(String user_fname) { this.user_fname = user_fname; }

    public String getUser_lname() { return user_lname; }

    public void setUser_lname(String user_lname) { this.user_lname = user_lname; }

    public String getUser_password() { return user_password; }

    public void setUser_password(String user_password) { this.user_password = user_password; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public boolean isEnabled() { return enabled; }

    public void setEnabled(boolean enabled) { this.enabled = enabled; }

    public String getRoles() { return roles; }

    public void setRoles(String roles) { this.roles = roles; }

}
