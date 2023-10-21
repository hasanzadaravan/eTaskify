package com.eTaskifyApi.eTaskify.controller;

import com.eTaskifyApi.eTaskify.dto.UserRequest;
import com.eTaskifyApi.eTaskify.dto.UserResponse;
import com.eTaskifyApi.eTaskify.model.Organization;
import com.eTaskifyApi.eTaskify.model.Role;
import com.eTaskifyApi.eTaskify.model.User;
import com.eTaskifyApi.eTaskify.services.OrganizationService;
import com.eTaskifyApi.eTaskify.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrganizationService organizationService;

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> addUser(@Valid @RequestBody UserRequest userRequest) {
        // Check if the organization exists
        Organization organization = organizationService.findById(userRequest.getOrganizationId());
        // Create and save the new user
        User newUser = new User();
        newUser.setName(userRequest.getName());
        newUser.setSurname(userRequest.getSurname());
        newUser.setEmail(userRequest.getEmail());
        newUser.setPassword("defaultPassword"); // Set a default password
        newUser.setRole(Role.USER);
        newUser = userService.createUser(newUser);

        // Add user to organization (update relationships if needed)

        return ResponseEntity.ok(new UserResponse(newUser));
    }
}
