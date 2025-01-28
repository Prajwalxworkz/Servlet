package com.xworkz.travelapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "form10")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "ph_number")
    private Long phNumber;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "travelling_to")
    private String travellingTo;
    @Column(name = "mode_of_transport")
    private String modeOfTransport;
}
