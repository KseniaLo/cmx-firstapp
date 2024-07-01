package ru.cinimex.firstapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.cinimex.firstapp.dto.AuthRequest;
import ru.cinimex.firstapp.dto.TokenResponse;
import ru.cinimex.firstapp.service.JwtService;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    @Override
    public ResponseEntity<TokenResponse> loginUser(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

        return ResponseEntity.ok(new TokenResponse(jwtService.generateToken(authenticate)));
    }

}
