package org.example.extendedtraveljournal.mapper;

import org.example.extendedtraveljournal.model.JournalEntity;
import org.mapstruct.*;
import org.openapitools.model.Journal;
import org.openapitools.model.JournalPutDto;
import org.openapitools.model.JournalPatchDto;

@Mapper(componentModel = "spring")
public interface JournalMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "user", ignore = true)
  JournalEntity toEntity(Journal dto);

  @Mapping(target = "userId", source = "user.id")
  Journal toDto(JournalEntity entity);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "user", ignore = true)
  JournalEntity putEntityFromDto(JournalPutDto dto, @MappingTarget JournalEntity entity);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "user", ignore = true)
  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  JournalEntity patchEntityFromDto(JournalPatchDto dto, @MappingTarget JournalEntity entity);
}
