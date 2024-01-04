package com.obuvki.rest.services;

import com.obuvki.rest.DTO.JwtAuthenticationResponse;
import com.obuvki.rest.DTO.RefreshTokenRequest;
import com.obuvki.rest.DTO.SignInRequest;
import com.obuvki.rest.DTO.SignUpRequest;
import com.obuvki.rest.Models.AppUser;

public interface AuthenticationService {

    AppUser signup(SignUpRequest signUpRequest);

    JwtAuthenticationResponse signin(SignInRequest signInRequest) throws IllegalAccessException;

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
