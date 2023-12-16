package com.travelmanagement.travelsystem.dto;

import lombok.Data;

@Data
public class AddHotelRequest {

    private String hotelName;
    private String hotelAddress;
    private String hotelEmail;

}
