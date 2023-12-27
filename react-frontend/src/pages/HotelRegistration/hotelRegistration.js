import React, { useState, useContext } from "react";
import { useNavigate } from "react-router-dom";
import { Grid } from "@mui/material";
import Typography from "@mui/material/Typography";
import TextField from "@mui/material/TextField";
import { toast } from "react-toastify";
import Button from "@mui/material/Button";
import UserContext from '../../components/ContextComponents/ContextComponents'

export default function HotelRegistration({ description }) {
  const [hotelRequest, setHotelRequest] = useState({});
  const navigate = useNavigate();
  const { user } = useContext(UserContext);
  const token = user.token

  const handleChange = (event) => {
    const name = event.target.name;
    const value = event.target.value;
    setHotelRequest((values) => ({ ...values, [name]: value }));
    console.log(hotelRequest);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await fetch("http://localhost:8080/api/v1/admin/addHotel", {
        method: "POST",
        headers: {
          'Content-Type': 'application/json',
          Authorization: `Bearer ${token}`
        },
        body: JSON.stringify({
          hotelName: hotelRequest.hotelName,
          hotelAddress: hotelRequest.address,
          hotelEmail: hotelRequest.hotelEmail,
          hotelDescription: hotelRequest.description,
          hotelCity : hotelRequest.city,
          hotelState : hotelRequest.state,
          hotelCountry : hotelRequest.country,
          hotelPostalCode : hotelRequest.zip
        }),
      });

      if (response.status === 200) {
        navigate("/userHome");
      } else {
        toast.warn("Please enter correct details..!", {
          position: "top-center",
          autoClose: 5000,
          hideProgressBar: false,
          closeOnClick: true,
          pauseOnHover: true,
          draggable: true,
          progress: undefined,
          theme: "light",
        });
      }
    } catch (error) {
      toast.warn("Please enter correct details..!", {
        position: "top-center",
        autoClose: 5000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: undefined,
        theme: "light",
      });
    }
  };
  return (
    <React.Fragment>
      <Typography variant="h6" gutterBottom>
        Hotel Registration
      </Typography>
      <form onSubmit={handleSubmit}>
      <Grid container spacing={3}>
        <Grid item xs={12} sm={6}>
          <TextField
            required
            id="hotelName"
            name="hotelName"
            label="Hotel Name"
            onChange={handleChange}
            fullWidth
            autoComplete="given-name"
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <TextField
            required
            id="hotelEmail"
            name="hotelEmail"
            label="Hotel Email"
            onChange={handleChange}
            fullWidth
            autoComplete="Hotel Email"
          />
        </Grid>
        <Grid item xs={12}>
          <TextField
            id="description"
            name="description"
            label="Description"
            onChange={handleChange}
            multiline
            fullWidth
            rows={3}
            placeholder="Minimum 250 words"
          />
        </Grid>
        <Grid item xs={12}>
          <TextField
            required
            id="address"
            name="address"
            label="Address"
            onChange={handleChange}
            fullWidth
            autoComplete="address"
          />
        </Grid>

        <Grid item xs={12} sm={6}>
          <TextField
            required
            id="city"
            name="city"
            label="City"
            onChange={handleChange}
            fullWidth
            autoComplete="city"
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <TextField
            id="state"
            name="state"
            onChange={handleChange}
            label="State/Province/Region"
            fullWidth
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <TextField
            required
            id="zip"
            name="zip"
            label="Zip / Postal code"
            onChange={handleChange}
            fullWidth
            autoComplete="shipping postal-code"
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <TextField
            required
            id="country"
            name="country"
            label="Country"
            onChange={handleChange}
            fullWidth
            autoComplete="shipping country"
          />
        </Grid>
        <Button
          type="submit"
          fullWidth
          variant="contained"
          sx={{ mt: 3, mb: 2 }}
        >
          Submit
        </Button>
      </Grid>
      </form>
    </React.Fragment>
  );
}
