package org.example.extendedtraveljournal.service;

import org.example.extendedtraveljournal.exception.ResourceNotFoundException;
import org.example.extendedtraveljournal.mapper.JournalEntryMapper;
import org.example.extendedtraveljournal.model.JournalEntity;
import org.example.extendedtraveljournal.model.JournalEntryEntity;
import org.example.extendedtraveljournal.repository.JournalEntryRepository;
import org.example.extendedtraveljournal.repository.JournalRepository;
import org.openapitools.model.JournalEntry;
import org.openapitools.model.JournalEntryPatchDto;
import org.openapitools.model.JournalEntryPutDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalEntryService {

  private final JournalEntryRepository journalEntryRepository;
  private final JournalRepository journalRepository;
  private final JournalEntryMapper journalEntryMapper;

  public JournalEntryService(
      JournalEntryRepository journalEntryRepository,
      JournalRepository journalRepository,
      JournalEntryMapper journalEntryMapper) {
    this.journalEntryRepository = journalEntryRepository;
    this.journalRepository = journalRepository;
    this.journalEntryMapper = journalEntryMapper;
  }

  public JournalEntry create(Integer journalId, JournalEntry dto) {
    JournalEntity journal =
        journalRepository
            .findById(journalId)
            .orElseThrow(() -> new ResourceNotFoundException(journalId));

    JournalEntryEntity entity = journalEntryMapper.toEntity(dto);
    entity.setId(null);
    entity.setJournal(journal);

    return journalEntryMapper.toDto(journalEntryRepository.save(entity));
  }

  public List<JournalEntry> getAllByJournalId(Integer journalId) {
    journalRepository
        .findById(journalId)
        .orElseThrow(() -> new ResourceNotFoundException(journalId));

    return journalEntryRepository.findAllByJournalId(journalId).stream()
        .map(journalEntryMapper::toDto)
        .toList();
  }

  public JournalEntry getById(Integer journalId, Integer entryId) {
    JournalEntryEntity entity =
        journalEntryRepository
            .findByIdAndJournalId(entryId, journalId)
            .orElseThrow(() -> new ResourceNotFoundException(entryId));
    return journalEntryMapper.toDto(entity);
  }

  public void deleteById(Integer journalId, Integer entryId) {
    if (!journalEntryRepository.existsByIdAndJournalId(entryId, journalId)) {
      throw new ResourceNotFoundException(entryId);
    }
    journalEntryRepository.deleteById(entryId);
  }

  public JournalEntry patchById(Integer journalId, Integer entryId, JournalEntryPatchDto dto) {
    JournalEntryEntity entity =
        journalEntryRepository
            .findByIdAndJournalId(entryId, journalId)
            .orElseThrow(() -> new ResourceNotFoundException(entryId));

    JournalEntryEntity updated = journalEntryMapper.patchEntityFromDto(dto, entity);
    return journalEntryMapper.toDto(journalEntryRepository.save(updated));
  }

  public JournalEntry putById(Integer journalId, Integer entryId, JournalEntryPutDto dto) {
    JournalEntryEntity entity =
        journalEntryRepository
            .findByIdAndJournalId(entryId, journalId)
            .orElseThrow(() -> new ResourceNotFoundException(entryId));

    JournalEntryEntity updated = journalEntryMapper.putEntityFromDto(dto, entity);
    return journalEntryMapper.toDto(journalEntryRepository.save(updated));
  }
}
