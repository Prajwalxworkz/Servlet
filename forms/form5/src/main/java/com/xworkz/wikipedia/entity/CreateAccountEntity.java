package com.xworkz.wikipedia.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "form5")
public class CreateAccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String password;
    private String confirmPassword;
    private String email;
    private String gender;
}
