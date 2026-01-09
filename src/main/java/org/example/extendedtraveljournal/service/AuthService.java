package org.example.extendedtraveljournal.service;

import org.example.extendedtraveljournal.model.UserEntity;
import org.example.extendedtraveljournal.repository.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public AuthService(UserRepository repo, PasswordEncoder passwordEncoder) {
    this.userRepository = repo;
    this.passwordEncoder = passwordEncoder;
  }

  public void register(org.openapitools.model.RegisterRequest r) {
    if (userRepository.existsByEmail(r.getEmail())) {
      throw new DataIntegrityViolationException("email_unique");
    }

    UserEntity u = new UserEntity();
    u.setName(r.getName());
    u.setSurname(r.getSurname());
    u.setEmail(r.getEmail());
    u.setPassword(passwordEncoder.encode(r.getPassword()));
    userRepository.save(u);
  }
}
