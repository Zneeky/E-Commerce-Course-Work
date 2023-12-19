package com.obuvki.rest.services;

import com.obuvki.rest.DTO.SignUpRequest;
import com.obuvki.rest.Models.AppUser;

public interface AuthenticationService {

    AppUser signup(SignUpRequest signUpRequest);
}
