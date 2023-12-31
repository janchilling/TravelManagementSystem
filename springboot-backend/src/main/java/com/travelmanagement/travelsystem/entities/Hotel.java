package com.travelmanagement.travelsystem.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String hotelName;

    private String hotelAddress;

    private String hotelEmail;

    private String hotelDescription;

    private String hotelCity;

    private String hotelState;

    private String hotelCountry;

    private String hotelPostalCode;
}
