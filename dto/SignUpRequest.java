package com.eTaskifyApi.eTaskify.dto;

import lombok.Data;

@Data
public class SignUpRequest {
    private String organizationName;
    private String phoneNumber;
    private String address;
    private String username;
    private String email;
    private String password;
}
