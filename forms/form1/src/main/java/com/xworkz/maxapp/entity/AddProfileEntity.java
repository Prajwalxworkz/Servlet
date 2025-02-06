package com.xworkz.maxapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "userDetails")
@NamedNativeQuery(name="getAllProfiles",query = "Select * from userdetails ",resultClass = AddProfileEntity.class)
@NamedQuery(name="deleteProfileById",query = "delete from AddProfileEntity form1 where form1.id=:id")
@NamedQuery(name="getProfileById",query = "select form1 from AddProfileEntity form1 where form1.id=:id")
public class AddProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "mobile")
    private Long mobile;
}
