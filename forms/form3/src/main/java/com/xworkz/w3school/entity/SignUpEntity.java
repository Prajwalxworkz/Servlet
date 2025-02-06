package com.xworkz.w3school.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "form3")
@NamedQuery(name="getAllProfiles",query = "select form3 from SignUpEntity form3 ")
@NamedQuery(name="deleteProfileById",query = "delete from SignUpEntity form3 where form3.id=:id")
@NamedQuery(name="getProfileById",query = "select form3 from SignUpEntity form3 where form3.id=:id")
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

