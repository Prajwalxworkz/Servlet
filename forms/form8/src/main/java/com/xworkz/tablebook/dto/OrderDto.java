package com.xworkz.tablebook.dto;

import lombok.Data;

@Data
public class OrderDto {
    private String userName;
    private Long phNumber;
    private Integer numberOfPersons;
    private String date;
}
