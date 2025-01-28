package com.xworkz.app.dto;

import lombok.Data;

@Data
public class AddProfileDto {

    private String userName;
    private String password;
    private String confirmPassword;
    private String email;
    private String city;
    private String state;
    private String country;
}
