package com.travelmanagement.travelsystem.services.Impl;

import com.travelmanagement.travelsystem.dto.AddHotelRequest;
import com.travelmanagement.travelsystem.entities.Hotel;
import com.travelmanagement.travelsystem.repository.HotelRepository;
import com.travelmanagement.travelsystem.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel addHotel(AddHotelRequest addHotelRequest){

        Hotel hotel = new Hotel();

        hotel.setHotelName(addHotelRequest.getHotelName());
        hotel.setHotelAddress(addHotelRequest.getHotelAddress());
        hotel.setHotelEmail(addHotelRequest.getHotelEmail());

        return hotelRepository.save(hotel);

    }

    public List<Hotel> getAllHotels(){
        return hotelRepository.findAll();
    }

    public Hotel findHotelById(Long hotelId){
        Optional<Hotel> hotel = hotelRepository.findById(hotelId);
        return hotel.orElse(null);
    }

    public Hotel updateHotelDetails(Long hotelId, AddHotelRequest addHotelRequest ) throws ChangeSetPersister.NotFoundException {

        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        hotel.setHotelName(addHotelRequest.getHotelName());
        hotel.setHotelAddress(addHotelRequest.getHotelAddress());
        hotel.setHotelEmail(addHotelRequest.getHotelEmail());

        return hotelRepository.save(hotel);
    }

    public void deleteHotel(Long hotelId) {
        hotelRepository.deleteById(hotelId);
    }

}
