package com.springboot.demo.SpringWebAPI.controller;



import com.springboot.demo.SpringWebAPI.dto.RegisterRequest;
import com.springboot.demo.SpringWebAPI.dto.LoginRequest;
import com.springboot.demo.SpringWebAPI.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        String token = authService.register(request);
        return ResponseEntity.ok(token); // return JWT
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        String token = authService.login(request);
        return ResponseEntity.ok(token); // return JWT
    }
    
    @GetMapping("/api/user/test")
    public ResponseEntity<String> testProtectedRoute() {
        return ResponseEntity.ok("Secured content accessed!");
    }

}
