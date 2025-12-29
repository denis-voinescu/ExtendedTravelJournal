package org.example.extendedtraveljournal.service;

import org.example.extendedtraveljournal.exception.ResourceNotFoundException;
import org.example.extendedtraveljournal.mapper.UserMapper;
import org.example.extendedtraveljournal.model.UserEntity;
import org.example.extendedtraveljournal.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.openapitools.model.User;
import org.openapitools.model.UserPatchDto;
import org.openapitools.model.UserPutDto;

import java.util.List;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public UserService(UserRepository userRepository, UserMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  public User create(User user) {
    UserEntity userEntity = userMapper.toEntity(user);
    UserEntity savedUserEntity = userRepository.save(userEntity);
    User userDto = userMapper.toDto(savedUserEntity);
    return userDto;
  }

  public List<User> getAll() {
    List<UserEntity> userEntities = userRepository.findAll();
    return userEntities.stream().map(userMapper::toDto).toList();
  }

  public User getById(Integer id) {
    UserEntity userEntity =
        userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    User userDto = userMapper.toDto(userEntity);
    return userDto;
  }

  public void deleteById(Integer id) {
    userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    userRepository.deleteById(id);
  }

  public User patchById(Integer id, UserPatchDto userPatchDto) {
    UserEntity userEntity =
        userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

    UserEntity updatedEntity = userMapper.patchEntityFromDto(userPatchDto, userEntity);
    userRepository.save(updatedEntity);

    User userDto = userMapper.toDto(updatedEntity);
    return userDto;
  }

  public User putById(Integer id, UserPutDto userPutDto) {
    UserEntity userEntity =
        userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

    UserEntity updatedEntity = userMapper.putEntityFromDto(userPutDto, userEntity);
    userRepository.save(updatedEntity);

    User userDto = userMapper.toDto(updatedEntity);
    return userDto;
  }
}
