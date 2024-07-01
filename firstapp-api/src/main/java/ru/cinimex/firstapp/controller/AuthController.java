package ru.cinimex.firstapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.cinimex.firstapp.dto.AuthRequest;
import ru.cinimex.firstapp.dto.TokenResponse;

@RequestMapping("/auth")
public interface AuthController {

    @PostMapping("/login")
    ResponseEntity<TokenResponse> loginUser(@RequestBody AuthRequest authRequest);
}
