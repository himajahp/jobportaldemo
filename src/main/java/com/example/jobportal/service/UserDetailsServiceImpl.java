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

import com.example.jobportal.model.User;
import com.example.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserDetailsServiceImpl {
    @Autowired
    private UserRepository userRepository;

    //get all users
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    // save user
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

}
