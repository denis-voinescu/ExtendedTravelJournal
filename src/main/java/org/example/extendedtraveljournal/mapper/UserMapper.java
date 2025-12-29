package org.example.extendedtraveljournal.mapper;

import org.example.extendedtraveljournal.model.UserEntity;
import org.mapstruct.MappingTarget;
import org.openapitools.model.User;
import org.mapstruct.Mapper;
import org.openapitools.model.UserPatchDto;
import org.openapitools.model.UserPutDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserEntity toEntity(User user);

  User toDto(UserEntity userEntity);

  UserEntity patchEntityFromDto(UserPatchDto userPatchDto, @MappingTarget UserEntity userEntity);

  UserEntity putEntityFromDto(UserPutDto userPutDto, @MappingTarget UserEntity userEntity);
}
