package com.example.jobportal.service;

//import com.example.jobportal.model.User;
//import com.example.jobportal.repository.UserRepository;
//import com.example.jobportal.security.MyUserDetails;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String user_name) throws UsernameNotFoundException {
//        User user = userRepository.getUserByUsername(user_name);
//        if(user == null) {
//            throw new UsernameNotFoundException("User not found!");
//        }
//        return new MyUserDetails(user);
//    }
//}

import com.example.jobportal.model.Employee;
import com.example.jobportal.model.User;
import com.example.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl {
    @Autowired
    private UserRepository userRepository;

    //get all users
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    // get user by id
     public User getUserById(int id) {
         Optional<User> optional = userRepository.findById(id);
         User user;
         if (optional.isPresent()) {
             user = optional.get();
         } else {
             throw new RuntimeException("User not found for id :: " + id);
         }
         return user;
    }

    // save user
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    // update user by themselves
    public User updateUserDetails(User user) {
        User currentUser = this.userRepository.getById(user.getUser_id());
        currentUser.setUser_fname(user.getUser_fname());
        currentUser.setUser_lname(user.getUser_lname());
        currentUser.setUser_password(user.getUser_password());
        currentUser.setEmail(user.getEmail());
        return this.userRepository.getById(user.getUser_id());
    }

    // update user by admin
    public User updateUserDetailsByAdmin(User user) {
        User currentUser = this.userRepository.getById(user.getUser_id());
        int id = user.getUser_id();
        currentUser.setUser_fname(user.getUser_fname());
        currentUser.setUser_lname(user.getUser_lname());
        currentUser.setEnabled(user.isEnabled());
        currentUser.setUser_password(user.getUser_password());
        currentUser.setEmail(user.getEmail());
        return this.userRepository.save(currentUser);
        //return this.userRepository.getById(user.getUser_id());
    }

    // delete user
    public void removeUser(int id) { this.userRepository.deleteById(id); }
}
