package com.xworkz.maxapp.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AddProfileDto {
    private Integer id;
    private String fullName;
    private String email;
    private String address;
    private Long mobile;

}
