package com.xworkz.app.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "form12")
public class AddProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String password;
    private String confirmPassword;
    private String email;
    private String city;
    private String state;
    private String country;
}
