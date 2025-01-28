package com.xworkz.oracle.dto;

import lombok.Data;

@Data
public class CreateAccountDto {
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;
    private String email;
    private String address;
    private long phNum;

}
