package com.xworkz.maxapp.dto;

import lombok.Data;

@Data
public class AddProfileDto {
    private String fullName;
    private String email;
    private String address;
    private Long mobile;

}
