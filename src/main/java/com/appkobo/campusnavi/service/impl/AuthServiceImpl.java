package com.appkobo.campusnavi.service.impl;

import com.appkobo.campusnavi.dto.JwtResponse;
import com.appkobo.campusnavi.dto.LoginRequest;
import com.appkobo.campusnavi.dto.SignupRequest;
import com.appkobo.campusnavi.dto.UserDto;
import com.appkobo.campusnavi.exception.UserAlreadyExistsException;
import com.appkobo.campusnavi.exception.UserNotFoundException;
import com.appkobo.campusnavi.model.User;
import com.appkobo.campusnavi.repository.UserRepository;
import com.appkobo.campusnavi.service.AuthService;
import com.appkobo.campusnavi.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public JwtResponse register(SignupRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException(request.getUsername());
        }

        User user = userRepository.save(
                User.builder()
                        .username(request.getUsername())
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .school(request.getSchool())
                        .build()
        );

        return JwtResponse.builder()
                .token(jwtUtil.generateToken(user))
                .user(
                        UserDto.builder()
                                .username(user.getUsername())
                                .email(user.getEmail())
                                .school(user.getSchool())
                                .build()
                )
                .build();
    }

    @Override
    public JwtResponse authenticate(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UserNotFoundException(request.getEmail()));

        return JwtResponse.builder()
                .token(jwtUtil.generateToken(user))
                .user(
                        UserDto.builder()
                                .username(user.getUsername())
                                .email(user.getEmail())
                                .school(user.getSchool())
                                .build()
                )
                .build();
    }
}
