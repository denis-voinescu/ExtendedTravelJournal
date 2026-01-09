package org.example.extendedtraveljournal.controller;

import org.example.extendedtraveljournal.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.openapitools.model.RegisterRequest;

@RestController
public class AuthController {
  private final AuthService authService;

  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  @PostMapping("/register")
  @ResponseStatus(HttpStatus.CREATED)
  public void register(@RequestBody RegisterRequest r) {
    authService.register(r);
  }
}
