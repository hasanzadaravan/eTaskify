package com.eTaskifyApi.eTaskify.dto;

import com.eTaskifyApi.eTaskify.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String email;

    @NotNull
    private Long organizationId;
}

