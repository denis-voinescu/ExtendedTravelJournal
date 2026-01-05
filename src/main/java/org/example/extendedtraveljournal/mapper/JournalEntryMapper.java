package org.example.extendedtraveljournal.mapper;

import org.example.extendedtraveljournal.model.JournalEntryEntity;
import org.mapstruct.*;
import org.openapitools.jackson.nullable.JsonNullable;
import org.openapitools.model.JournalEntry;
import org.openapitools.model.JournalEntryPatchDto;
import org.openapitools.model.JournalEntryPutDto;

import java.time.LocalDate;

@Mapper(componentModel = "spring")
public interface JournalEntryMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "journal", ignore = true)
  JournalEntryEntity toEntity(JournalEntry dto);

  @Mapping(target = "journalId", source = "journal.id")
  JournalEntry toDto(JournalEntryEntity entity);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "journal", ignore = true)
  JournalEntryEntity patchEntityFromDto(
      JournalEntryPatchDto dto, @MappingTarget JournalEntryEntity entity);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "journal", ignore = true)
  JournalEntryEntity putEntityFromDto(
      JournalEntryPutDto dto, @MappingTarget JournalEntryEntity entity);

  default String map(JsonNullable<String> v) {
    return v != null && v.isPresent() ? v.get() : null;
  }

  default LocalDate mapDate(JsonNullable<LocalDate> v) {
    return v != null && v.isPresent() ? v.get() : null;
  }

  default JsonNullable<String> map(String v) {
    return v == null ? JsonNullable.undefined() : JsonNullable.of(v);
  }

  default JsonNullable<LocalDate> mapDate(LocalDate v) {
    return v == null ? JsonNullable.undefined() : JsonNullable.of(v);
  }
}
