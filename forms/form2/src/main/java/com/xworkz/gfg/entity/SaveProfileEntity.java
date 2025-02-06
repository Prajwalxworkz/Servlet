package com.xworkz.gfg.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "form2")
@NamedQuery(name="getAllProfiles",query="select form2 from SaveProfileEntity form2")
@NamedQuery(name="getProfileById",query="select form2 from SaveProfileEntity form2 where form2.id=:id")
@NamedQuery(name="deleteProfileById",query="delete from SaveProfileEntity form2 where form2.id=:id")
public class SaveProfileEntity {
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
    @Column(name="gender")
    private String gender;
    @Column(name="address")
    private String address;
}
