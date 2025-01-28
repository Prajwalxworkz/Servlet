package com.xworkz.app.dto;

import lombok.Data;

@Data
public class AddProfileDto {

    private String userName;
    private Long phNumber;
    private String accountType;
    private String amount;
    private String accountNumber;
}
