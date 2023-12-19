package com.obuvki.rest.services;

import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;

@Service
public interface JWTService {

    String extractUserName(String token);

    String generateToken(UserDetails userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);

}
