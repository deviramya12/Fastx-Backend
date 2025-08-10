package com.springboot.demo.SpringWebAPI.controller;


import com.springboot.demo.SpringWebAPI.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    // 🔒 Secured endpoint to get current user
    @GetMapping("/me")
    public ResponseEntity<?> getProfile() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        return userService.getUserByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Just for testing secured access (optional)
    @GetMapping("/test")
    public ResponseEntity<String> testProtectedRoute() {
        return ResponseEntity.ok(" Secured content accessed!");
    }
}
