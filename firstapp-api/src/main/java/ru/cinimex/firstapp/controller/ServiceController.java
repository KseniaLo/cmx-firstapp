package ru.cinimex.firstapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/test")
public interface ServiceController {

    @GetMapping("/user")
    ResponseEntity<String> user();

    @GetMapping("/admin")
    ResponseEntity<String> admin();
}
