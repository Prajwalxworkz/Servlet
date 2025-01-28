package com.xworkz.account.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "form13")
public class AddProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String password;
    private String confirmPassword;
    private String email;
    private String gender;
    private String state;
    private String country;
}
