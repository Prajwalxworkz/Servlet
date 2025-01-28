package com.xworkz.app.dto;

import lombok.Data;

@Data
public class AddProfileDto {

    private String firstName;
    private String lastName;
    private String highestEducation;
    private String email;
    private String gender;
    private String address;
    private Long phNumber;
    private String resume;
}
