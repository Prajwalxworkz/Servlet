package com.xworkz.app.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "form18")
public class AddProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private Long phNumber;
    private String accountType;
    private String amount;
    private String accountNumber;
}
