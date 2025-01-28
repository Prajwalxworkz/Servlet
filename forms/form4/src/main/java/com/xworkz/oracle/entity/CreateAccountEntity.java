package com.xworkz.oracle.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "form4")
public class CreateAccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;
    private String email;
    private String address;
    private long phNum;
}
