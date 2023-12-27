import React, { useState } from "react";
import dayjs from "dayjs";
import Button from "@mui/material/Button";
import TextField from "@mui/material/TextField";
import { LocalizationProvider } from "@mui/x-date-pickers/LocalizationProvider";
import { DatePicker } from "@mui/x-date-pickers/DatePicker";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";

export default function BookingComponent({ hotelId, userId, token }) {
  const [checkInDate, setCheckInDate] = useState(dayjs());
  const [checkOutDate, setCheckOutDate] = useState(dayjs());

  const handleButtonClick = () => {
    
    fetch('http://localhost:8080/api/v1/bookings', {
      method: 'POST',
      body: JSON.stringify({ hotelId, userId, checkInDate, checkOutDate }),
      headers: {
        Authorization: `Bearer ${token}`,
        'Content-Type': 'application/json'
      }
    }).then(response => {
      // Handle the response from the server
    }).catch(error => {
      // Handle errors
    });
  };

  return (
    <LocalizationProvider dateAdapter={AdapterDayjs}>
      <div>
        <DatePicker
          label="Check-in Date"
          value={checkInDate}
          onChange={(newValue) => setCheckInDate(newValue)}
          textField={(params) => <TextField {...params} />}
        />
        <DatePicker
          label="Check-out Date"
          value={checkOutDate}
          onChange={(newValue) => setCheckOutDate(newValue)}
          textField={(params) => <TextField {...params} />}
        />
        <Button variant="contained" onClick={handleButtonClick}>
          Book
        </Button>
      </div>
    </LocalizationProvider>
  );
}
