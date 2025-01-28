package com.xworkz.passport.dto;

import lombok.Data;

@Data
public class AddProfileDto {

    private String firstName;
    private String lastName;
    private String dob;
    private String email;
    private String address;
}
