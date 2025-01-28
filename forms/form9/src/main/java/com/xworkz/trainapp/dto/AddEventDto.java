package com.xworkz.trainapp.dto;

import lombok.Data;

@Data
public class AddEventDto {
    private String firstName;
    private String lastName;
    private String dob;
    private String email;
    private Long trainNumber;
}
