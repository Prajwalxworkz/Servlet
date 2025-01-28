package com.xworkz.tablebook.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "form8")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private Long phNumber;
    @Column(name="num_of_persons")
    private Integer numberOfPersons;
    private String date;
}
