package com.xworkz.app.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "form16")
public class AddProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;
    private String email;
    private String gender;
    private String address;
    private Long phNumber;
}
