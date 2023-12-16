package com.travelmanagement.travelsystem.services;

import com.travelmanagement.travelsystem.dto.JwtAuthenticationResponse;
import com.travelmanagement.travelsystem.dto.LoginRequest;
import com.travelmanagement.travelsystem.dto.RefreshTokenRequest;
import com.travelmanagement.travelsystem.dto.SignUpRequest;
import com.travelmanagement.travelsystem.entities.User;

public interface AuthenticationService {

    User signup(SignUpRequest signUpRequest);

    JwtAuthenticationResponse login(LoginRequest loginRequest);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

}
