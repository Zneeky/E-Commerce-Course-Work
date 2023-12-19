package com.obuvki.rest.DTO;

import lombok.Data;

@Data
public class SignInRequest {

    private String email;

    private String password;
}
