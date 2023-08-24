package com.appkobo.campusnavi.service;


import com.appkobo.campusnavi.dto.JwtResponse;
import com.appkobo.campusnavi.dto.LoginRequest;
import com.appkobo.campusnavi.dto.SignupRequest;

public interface AuthService {
    JwtResponse register(SignupRequest request);
    JwtResponse authenticate(LoginRequest request);
}
