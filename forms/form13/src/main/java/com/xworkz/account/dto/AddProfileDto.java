package com.xworkz.account.dto;

import lombok.Data;

@Data
public class AddProfileDto {

    private String userName;
    private String password;
    private String confirmPassword;
    private String email;
    private String gender;
    private String state;
    private String country;
}
