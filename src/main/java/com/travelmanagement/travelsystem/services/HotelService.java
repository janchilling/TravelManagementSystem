package com.travelmanagement.travelsystem.services;

import com.travelmanagement.travelsystem.dto.AddHotelRequest;
import com.travelmanagement.travelsystem.entities.Hotel;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface HotelService {

    Hotel addHotel(AddHotelRequest addHotelRequest);

    public List<Hotel> getAllHotels();

    public Hotel findHotelById(Long hotelId);

    Hotel updateHotelDetails(Long hotelId, AddHotelRequest addHotelRequest ) throws ChangeSetPersister.NotFoundException;

    void deleteHotel(Long hotelId);

}
