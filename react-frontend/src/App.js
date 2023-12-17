import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import React, { useState, useEffect } from 'react';
import UserContext from "./components/ContextComponents/ContextComponents";

// headers
import Header from './components/Common/ManagementHeader/adminHeader';
import Footer from './components/Common/ManagementFooter/adminFooter';

// User management
import Index from './pages/Index/index';
import Login from './components/Auth/login';
import UserHome from './pages/UserHome/userHome'


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
          <Header/>
          <Routes>
            {/* user management */}
            <Route path="" element={<Index />} />
            <Route path="/login" element={<Login />} />
            <Route path="/userHome" element={<userHome />} />

            {/* <Route path='/deleteAllocation/:id' element={<DeleteAllocation/>} /> */}

            

          </Routes>
        </div>
        <Footer/>
      </UserContext.Provider>
    </Router>
  );
}

export default App;