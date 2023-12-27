import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import React, { useState, useEffect } from 'react';
import UserContext from "./components/ContextComponents/ContextComponents";

// User management
import Index from './pages/Index/index';
import Login from './components/Auth/login';
import Register from './pages/Register/register'
import UserHome from './pages/UserHome/userHome'
import AllHotels from './pages/allHotels/allHotels'
import SingleHotelPage from './pages/SingleHotel/hotel';


import HotelRegistration from './pages/HotelRegistration/hotelRegistration';


// import DeleteAllocation from ''

function App() {
  // user details pass
  const [user, setUser] = useState(() => {
    const storedUser = localStorage.getItem('User');
    return storedUser ? JSON.parse(storedUser) : null;
  });
  useEffect(() => {
    if (user) {
      localStorage.setItem('User', JSON.stringify(user));
    } else {
      localStorage.removeItem('User');
    }
  }, [user]);

  return (
    <Router>
      <UserContext.Provider value={{ user, setUser }}>
        <div className="App">
          <Routes>
            {/* user management */}
            <Route path="" element={<Index />} />
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />
            <Route path="/userHome" element={<UserHome />} />
            <Route path="/allHotels" element={<AllHotels />} />
            <Route path="/hotel/:id"  element={<SingleHotelPage />} />

            {/* <Route path='/deleteAllocation/:id' element={<DeleteAllocation/>} /> */}
            <Route path="/hotel/addHotel"  element={<HotelRegistration />} />

            

          </Routes>
        </div>
      </UserContext.Provider>
    </Router>
  );
}

export default App;