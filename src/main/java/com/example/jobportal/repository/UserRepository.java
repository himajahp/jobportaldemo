package com.example.jobportal.repository;

import com.example.jobportal.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("Select u from User u where u.user_name = :user_name")
    public User getUserByUsername(@Param("user_name") String user_name);
}
