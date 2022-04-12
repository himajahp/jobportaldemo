package com.example.jobportal.repository;

import com.example.jobportal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("Select u from User u where u.user_fname = :user_fname")
    public User getUserByUsername(@Param("user_fname") String user_fname);
    
}
