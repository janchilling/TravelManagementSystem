package com.travelmanagement.travelsystem.services;

import com.travelmanagement.travelsystem.dto.BookingRequest;
import com.travelmanagement.travelsystem.entities.Booking;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface BookingService {
    Booking addBooking(BookingRequest bookingRequest);

    Booking updateBooking(Long bookingId, BookingRequest bookingRequest) throws ChangeSetPersister.NotFoundException;

    List<Booking> getAllBookings();

    Booking findBookingById(Long bookingId);

    List<Booking> findBookingsByHotelId(Long hotelId);

    List<Booking> findBookingsByUserId(Long userId);
}
