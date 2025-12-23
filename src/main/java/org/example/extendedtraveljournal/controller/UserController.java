package org.example.extendedtraveljournal.controller;

import org.example.extendedtraveljournal.service.UserService;
import org.openapitools.model.User;
import org.openapitools.model.UserPatchDto;
import org.openapitools.model.UserPutDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.openapitools.api.UsersApi;

import java.util.List;

@RestController
public class UserController implements UsersApi {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<User> createUser(User user) {
        User created = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Override
    public ResponseEntity<Void> deleteUserById(Integer id) {
        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @Override
    public ResponseEntity<User> getUserById(Integer id) {
        User user = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @Override
    public ResponseEntity<User> patchUserById(Integer id, UserPatchDto userPatchDto) {
        return null;
    }

    @Override
    public ResponseEntity<User> putUserById(Integer id, UserPutDto userPutDto) {
        return null;
    }
}
