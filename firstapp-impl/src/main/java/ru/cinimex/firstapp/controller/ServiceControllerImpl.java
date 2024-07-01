package ru.cinimex.firstapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceControllerImpl implements ServiceController {

    @Override
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> user() {
        return ResponseEntity.ok("OK");
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> admin() {
        return ResponseEntity.ok("OK");
    }
}
