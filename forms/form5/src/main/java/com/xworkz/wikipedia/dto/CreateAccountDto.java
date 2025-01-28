package com.xworkz.wikipedia.dto;

import lombok.Data;

@Data
public class CreateAccountDto {
    private String userName;
    private String password;
    private String confirmPassword;
    private String email;
    private String gender;

}
