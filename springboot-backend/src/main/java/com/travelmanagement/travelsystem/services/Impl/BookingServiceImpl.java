package com.travelmanagement.travelsystem.services.Impl;

import com.travelmanagement.travelsystem.dto.BookingRequest;
import com.travelmanagement.travelsystem.entities.Booking;
import com.travelmanagement.travelsystem.entities.Hotel;
import com.travelmanagement.travelsystem.entities.User;
import com.travelmanagement.travelsystem.repository.BookingRepository;
import com.travelmanagement.travelsystem.services.BookingService;
import com.travelmanagement.travelsystem.services.HotelService;
import com.travelmanagement.travelsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    BookingRepository bookingRepository;
    HotelService hotelService;
    UserService userService;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, HotelService hotelService, UserService userService){
        this.bookingRepository = bookingRepository;
        this.hotelService = hotelService;
        this.userService = userService;
    }
    public Booking addBooking(BookingRequest bookingRequest){

        Hotel hotel = hotelService.findHotelById(bookingRequest.getHotelId());
        User user = userService.getUserById(bookingRequest.getUserId());

        Booking booking = new Booking();

        booking.setBookingId(bookingRequest.getBookingId());
        booking.setHotel(hotel);
        booking.setUser(user);
        booking.setCheckInDate(bookingRequest.getCheckInDate());
        booking.setCheckOutDate((bookingRequest.getCheckOutDate()));

        return bookingRepository.save(booking);

    }

    public Booking updateBooking(Long bookingId, BookingRequest bookingRequest) throws ChangeSetPersister.NotFoundException {

        Hotel hotel = hotelService.findHotelById(bookingRequest.getHotelId());
        User user = userService.getUserById(bookingRequest.getUserId());

        Booking booking = bookingRepository.findById(bookingRequest.getBookingId()).orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        booking.setBookingId(bookingRequest.getBookingId());
        booking.setHotel(hotel);
        booking.setUser(user);
        booking.setCheckInDate(bookingRequest.getCheckInDate());
        booking.setCheckOutDate((bookingRequest.getCheckOutDate()));

        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    public Booking findBookingById(Long bookingId){
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        return booking.orElse(null);
    }

    public List<Booking> findBookingsByHotelId(Long hotelId){
        return bookingRepository.findAllByHotelId(hotelId);
    }

    public List<Booking> findBookingsByUserId(Long userId){
        return bookingRepository.findAllByUserId(userId);
    }
}
