package com.football.tracker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("player")
public class PlayerController {

    @GetMapping
    public ResponseEntity<?> getAllPlayers() {
        return ResponseEntity.accepted().body("Player");
    }
}
