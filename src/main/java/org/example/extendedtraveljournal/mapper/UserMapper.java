package org.example.extendedtraveljournal.mapper;

import org.example.extendedtraveljournal.model.UserEntity;
import org.openapitools.model.User;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring")
public interface UserMapper {

    UserEntity toEntity(User user);

    User toDto(UserEntity userEntity);
}
