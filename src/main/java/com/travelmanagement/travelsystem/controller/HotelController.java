package com.travelmanagement.travelsystem.controller;

import com.travelmanagement.travelsystem.dto.AddHotelRequest;
import com.travelmanagement.travelsystem.dto.SignUpRequest;
import com.travelmanagement.travelsystem.entities.Hotel;
import com.travelmanagement.travelsystem.entities.User;
import com.travelmanagement.travelsystem.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<Hotel>> allHotels(){
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long hotelId) {
        Hotel hotel = hotelService.findHotelById(hotelId);
        if (hotel != null) {
            return ResponseEntity.ok(hotel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
