package com.travelmanagement.travelsystem.repository;

import com.travelmanagement.travelsystem.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findAllByHotelId(Long hotelId);

    List<Booking> findAllByUserId(Long userId);

}
