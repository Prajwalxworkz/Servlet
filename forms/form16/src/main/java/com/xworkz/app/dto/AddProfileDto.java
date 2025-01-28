package com.xworkz.app.dto;

import lombok.Data;

@Data
public class AddProfileDto {

    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;
    private String email;
    private String gender;
    private String address;
    private Long phNumber;
}
