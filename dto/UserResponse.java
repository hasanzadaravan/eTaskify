package com.eTaskifyApi.eTaskify.dto;

import com.eTaskifyApi.eTaskify.model.User;
import lombok.Data;

@Data
public class UserResponse {
    private String name;
    private String surname;
    private String email;

    public UserResponse(User user) {
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
    }
}
