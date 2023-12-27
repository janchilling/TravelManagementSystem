import React, { useState, useEffect, useContext } from 'react';
import { toast } from 'react-toastify';
import { useNavigate } from 'react-router-dom';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import UserContext from '../../components/ContextComponents/ContextComponents'

const defaultTheme = createTheme();

export default function SignInSide() {
  const [hotelData, setHotelData] = useState([]);
  const navigate = useNavigate();
  const { user } = useContext(UserContext);
  const token = user.token

  useEffect(() => {
    const fetchHotelData = async () => {
      try {
        const response = await fetch('http://localhost:8080/api/v1/hotels', {
          method: 'GET',
          headers: {
            Authorization: `Bearer ${token}`
          }
        });

        if (!response.ok) {
          throw new Error('Failed to fetch data');
        }

        const data = await response.json();
        setHotelData(data);
      } catch (error) {
        toast.error('Error fetching hotel data');
        console.error(error);
      }
    };

    fetchHotelData();
  }, [token]);

  return (
    <ThemeProvider theme={defaultTheme}>
      {hotelData.map((hotel, index) => (
        <Card key={index} sx={{ maxWidth: 345 }}>
          <CardMedia
            component="img"
            alt={hotel.hotelName}
            height="140"
            // image={hotel.imageUrl}
          />
          <CardContent>
            <Typography gutterBottom variant="h5" component="div">
              {hotel.hotelName}
            </Typography>
            <Typography variant="body2" color="text.secondary">
              {/* {hotel.description} */}
            </Typography>
          </CardContent>
          <CardActions>
            <Button size="small">Share</Button>
            <Button size="small" onClick={() => navigate(`/hotel/${hotel.id}`)}>Learn More</Button>
          </CardActions>
        </Card>
      ))}
    </ThemeProvider>
  );
}
