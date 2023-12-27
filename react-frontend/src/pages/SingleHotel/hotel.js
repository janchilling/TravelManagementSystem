import React, { useState, useEffect, useContext } from 'react';
import { useParams } from 'react-router-dom';
import { Typography, Card, CardContent } from '@mui/material';
import BookingComponent from '../../components/BookingComponent/bookingComponent';
import UserContext from '../../components/ContextComponents/ContextComponents'

export default function SingleHotelPage() {
  const { id } = useParams();
  const [hotelData, setHotelData] = useState(null);
  const { user } = useContext(UserContext);
  const userId = user.userId
  const token = user.token

  useEffect(() => {
    const fetchHotelById = async () => {
      try {

        const response = await fetch(`http://localhost:8080/api/v1/hotels/${id}`, { 
            method : 'GET',
            headers : {
                authorization : `Bearer ${token}`
            }
        });
        if (response.ok) {
          const data = await response.json();
          setHotelData(data);
        } else {
          throw new Error('Failed to fetch hotel');
        }
      } catch (error) {
        console.error(error);
      }
    };

    fetchHotelById();
  }, [id, token]); 


  return (
    <div>
      <Typography variant="h4">Hotel Details</Typography>
      {hotelData ? (
        <Card>
          <CardContent>
            <Typography variant="h5">{hotelData.hotelName}</Typography>
            <Typography variant="body1">{hotelData.description}</Typography>
            {/* Add other hotel details you want to display */}
          </CardContent>
        </Card>
      ) : (
        <Typography variant="body1">Loading...</Typography>
      )}
      <BookingComponent hotelId={id} userId={userId} token={token} />
    </div>
  );
}
