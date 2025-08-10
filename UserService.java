package com.springboot.demo.SpringWebAPI.service;


import com.springboot.demo.SpringWebAPI.entity.User;
import com.springboot.demo.SpringWebAPI.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // (Optional) For update feature
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
