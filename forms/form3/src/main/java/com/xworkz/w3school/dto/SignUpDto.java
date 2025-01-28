package com.xworkz.w3school.dto;

import lombok.Data;

@Data
public class SignUpDto {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String gender;

}
