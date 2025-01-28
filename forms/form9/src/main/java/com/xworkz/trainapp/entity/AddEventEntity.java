package com.xworkz.trainapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "form9")
public class AddEventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    private String dob;
    private String email;
    @Column(name="train_number")
    private Long trainNumber;
}
