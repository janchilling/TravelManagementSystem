package com.travelmanagement.travelsystem.controller;

import com.travelmanagement.travelsystem.dto.AddHotelRequest;
import com.travelmanagement.travelsystem.entities.Hotel;
import com.travelmanagement.travelsystem.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final HotelService hotelService;

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hi admin");
    }

    @PostMapping("/addHotel")
    public ResponseEntity<Hotel> addHotel(@RequestBody AddHotelRequest addHotelRequest){
        return ResponseEntity.ok(hotelService.addHotel(addHotelRequest));
    }

    @PutMapping("/{hotelId}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable Long hotelId, @RequestBody AddHotelRequest addHotelRequest) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(hotelService.updateHotelDetails(hotelId, addHotelRequest));
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<String> deleteHotel(@PathVariable Long hotelId){
        hotelService.deleteHotel(hotelId);
        return ResponseEntity.ok("The hotel with ID " + hotelId + " has been deleted.");
    }

}
