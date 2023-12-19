package com.obuvki.rest.services.impl;

import com.obuvki.rest.DTO.SignUpRequest;
import com.obuvki.rest.Models.AppUser;
import com.obuvki.rest.Models.Role;
import com.obuvki.rest.repository.UserRepository;
import com.obuvki.rest.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public AppUser signup(SignUpRequest signUpRequest){
        AppUser user = new AppUser();

        user.setEmail(signUpRequest.getEmail());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        return userRepository.save(user);
    }
}
