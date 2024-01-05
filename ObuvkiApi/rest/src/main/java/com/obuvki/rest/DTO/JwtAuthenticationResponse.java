package com.obuvki.rest.DTO;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {

    private String token;

    private String refreshToken;

    private long userId;

    private String userEmail;
}
