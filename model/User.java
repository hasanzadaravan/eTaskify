package com.eTaskifyApi.eTaskify.model;

import com.eTaskifyApi.eTaskify.model.Task;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 6)
    private String password;

    private String name;
    private String surname;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToMany(mappedBy = "assignees")
    private Set<Task> tasks;
    // Other fields and relationships can be added here
}

