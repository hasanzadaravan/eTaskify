package com.eTaskifyApi.eTaskify.controller;

import com.eTaskifyApi.eTaskify.dto.SignInRequest;
import com.eTaskifyApi.eTaskify.dto.SignUpRequest;
import com.eTaskifyApi.eTaskify.services.AuthenticationService;
import com.eTaskifyApi.eTaskify.services.OrganizationService;
import com.eTaskifyApi.eTaskify.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

        return ResponseEntity.ok("User registered successfully");
    }

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody SignInRequest signInRequest) {
        boolean isAuthenticated = authenticationService.authenticate(signInRequest.getUsername(), signInRequest.getPassword());
        if (isAuthenticated) {
            return ResponseEntity.ok("User signed in successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid username or password");
        }
    }
}
