package com.travelmanagement.travelsystem.controller;

import com.travelmanagement.travelsystem.dto.AddHotelRequest;
import com.travelmanagement.travelsystem.dto.BookingRequest;
import com.travelmanagement.travelsystem.entities.Booking;
import com.travelmanagement.travelsystem.entities.Hotel;
import com.travelmanagement.travelsystem.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/addBooking")
    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequest bookingRequest){
        return ResponseEntity.ok(bookingService.addBooking(bookingRequest));
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long bookingId, @RequestBody BookingRequest bookingRequest) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(bookingService.updateBooking(bookingId, bookingRequest));
    }

    @GetMapping
    public ResponseEntity<List<Booking>> allBookings(){
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long bookingId) {
        Booking booking = bookingService.findBookingById(bookingId);
        if (booking != null) {
            return ResponseEntity.ok(booking);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/userBookings/{userId}")
    public ResponseEntity<List<Booking>> getBookingsByUserId(@PathVariable Long userId) {
        List<Booking> bookings = bookingService.findBookingsByUserId(userId);
        if (bookings != null) {
            return ResponseEntity.ok(bookings);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/hotelBookings/{hotelId}")
    public ResponseEntity<List<Booking>> getBookingsByHotelId(@PathVariable Long hotelId) {
        List<Booking> bookings = bookingService.findBookingsByHotelId(hotelId);
        if (bookings != null) {
            return ResponseEntity.ok(bookings);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
