package org.example.extendedtraveljournal.mapper;

import org.example.extendedtraveljournal.model.JournalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.openapitools.model.Journal;
import org.openapitools.model.JournalPutDto;
import org.openapitools.model.JournalPatchDto;

@Mapper(componentModel = "spring")
public interface JournalMapper {

  JournalEntity toEntity(Journal journal);

  Journal toDto(JournalEntity journalEntity);

  JournalEntity patchEntityFromDto(
      JournalPatchDto journal, @MappingTarget JournalEntity journalEntity);

  JournalEntity putEntityFromDto(JournalPutDto journal, @MappingTarget JournalEntity journalEntity);
}
