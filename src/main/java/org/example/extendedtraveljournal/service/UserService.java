package org.example.extendedtraveljournal.service;

import org.example.extendedtraveljournal.mapper.UserMapper;
import org.example.extendedtraveljournal.model.UserEntity;
import org.example.extendedtraveljournal.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.openapitools.model.User;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User createUser(User user) {
        UserEntity userEntity = userMapper.toEntity(user);
        UserEntity savedUserEntity = userRepository.save(userEntity);
        User userDto = userMapper.toDto(savedUserEntity);
        return userDto;
    }

    public List<User> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream()
                .map(userMapper::toDto)
                .toList();
    }

    public User getUserById(Integer id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        User userDto = userMapper.toDto(userEntity);
        return userDto;
    }

    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

}
