package com.xworkz.passport.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "form7")
public class AddProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="dob")
    private String dob;
    @Column(name="email")
    private String email;
    @Column(name="address")
    private String address;
}
