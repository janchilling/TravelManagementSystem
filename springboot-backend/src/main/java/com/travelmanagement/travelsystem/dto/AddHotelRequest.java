package com.travelmanagement.travelsystem.dto;

import lombok.Data;

@Data
public class AddHotelRequest {

    private String hotelName;
    private String hotelAddress;
    private String hotelEmail;
    private String hotelDescription;
    private String hotelCity;
    private String hotelState;
    private String hotelCountry;
    private String hotelPostalCode;

}
