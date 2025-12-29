package org.example.extendedtraveljournal.service;

import org.example.extendedtraveljournal.exception.ResourceNotFoundException;
import org.example.extendedtraveljournal.mapper.JournalMapper;
import org.example.extendedtraveljournal.model.JournalEntity;
import org.example.extendedtraveljournal.repository.JournalRepository;
import org.springframework.stereotype.Service;
import org.openapitools.model.Journal;
import org.openapitools.model.JournalPatchDto;
import org.openapitools.model.JournalPutDto;

import java.util.List;

@Service
public class JournalService {

  private final JournalRepository journalRepository;
  private final JournalMapper journalMapper;

  public JournalService(JournalRepository journalRepository, JournalMapper journalMapper) {
    this.journalRepository = journalRepository;
    this.journalMapper = journalMapper;
  }

  public Journal create(Journal journal) {
    JournalEntity journalEntity = journalMapper.toEntity(journal);
    JournalEntity savedJournalEntity = journalRepository.save(journalEntity);
    Journal journalDto = journalMapper.toDto(savedJournalEntity);
    return journalDto;
  }

  public List<Journal> getAll() {
    List<JournalEntity> journalEntities = journalRepository.findAll();
    List<Journal> journals = journalEntities.stream().map(journalMapper::toDto).toList();
    return journals;
  }

  public Journal getById(Integer id) {
    JournalEntity journalEntity =
        journalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    Journal journalDto = journalMapper.toDto(journalEntity);
    return journalDto;
  }

  public void deleteById(Integer id) {
    journalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    journalRepository.deleteById(id);
  }

  public Journal patchById(Integer id, JournalPatchDto journalPatchDto) {
    JournalEntity journalEntity =
        journalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

    JournalEntity updatedEntity = journalMapper.patchEntityFromDto(journalPatchDto, journalEntity);
    journalRepository.save(updatedEntity);
    Journal journalDto = journalMapper.toDto(updatedEntity);
    return journalDto;
  }

  public Journal putById(Integer id, JournalPutDto journalPutDto) {
    JournalEntity journalEntity =
        journalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

    JournalEntity updatedEntity = journalMapper.putEntityFromDto(journalPutDto, journalEntity);
    journalRepository.save(updatedEntity);
    Journal journalDto = journalMapper.toDto(updatedEntity);
    return journalDto;
  }
}
