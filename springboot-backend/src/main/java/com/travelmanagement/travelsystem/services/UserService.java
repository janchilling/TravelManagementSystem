package com.travelmanagement.travelsystem.services;

import com.travelmanagement.travelsystem.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

    UserDetailsService userDetailsService();

    User getUserById(Long id);

}
