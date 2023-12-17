package com.travelmanagement.travelsystem.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Data
@Entity
@Table(name = "Bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne()
    @JoinColumn( name = "hotel_id")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn( name = "user_id")
    private User user;

    private LocalDate checkInDate;
    private LocalDate checkOutDate;

}
