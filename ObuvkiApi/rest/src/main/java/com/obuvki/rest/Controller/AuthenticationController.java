package com.obuvki.rest.Controller;

import com.obuvki.rest.DTO.JwtAuthenticationResponse;
import com.obuvki.rest.DTO.SignInRequest;
import com.obuvki.rest.DTO.SignUpRequest;
import com.obuvki.rest.Models.AppUser;
import com.obuvki.rest.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<AppUser> signup(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signup(signUpRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest signInRequest) throws IllegalAccessException {
        return ResponseEntity.ok(authenticationService.signin(signInRequest));
    }
}
