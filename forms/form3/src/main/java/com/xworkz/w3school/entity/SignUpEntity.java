package com.xworkz.w3school.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "form3")
public class SignUpEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @Column(name="first_name")
    private String firstName;
//    @Column(name="last_name")
    private String lastName;
//    @Column(name="dob")
    private String password;
//    @Column(name="email")
    private String email;
//    @Column(name="gender")
    private String gender;
//    @Column(name="address")

}

