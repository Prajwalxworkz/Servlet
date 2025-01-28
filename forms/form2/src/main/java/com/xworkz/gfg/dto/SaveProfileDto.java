package com.xworkz.gfg.dto;

import lombok.Data;

@Data
public class SaveProfileDto {
    private String firstName;
    private String lastName;
    private String dob;
    private String email;
    private String gender;
    private String address;
}
