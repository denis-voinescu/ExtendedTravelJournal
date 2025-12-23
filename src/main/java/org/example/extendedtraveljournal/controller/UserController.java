package org.example.extendedtraveljournal.controller;

import org.openapitools.model.User;
import org.openapitools.model.UserPatchDto;
import org.openapitools.model.UserPutDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.openapitools.api.UsersApi;

import java.util.List;


@RestController
public class UserController implements UsersApi{
    @Override
    public ResponseEntity<User> createUser(User user) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteUserById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        return null;
    }

    @Override
    public ResponseEntity<User> getUserById(Integer id) {
        return null;
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
