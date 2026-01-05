package org.example.extendedtraveljournal.service;

import org.example.extendedtraveljournal.exception.ResourceNotFoundException;
import org.example.extendedtraveljournal.mapper.JournalMapper;
import org.example.extendedtraveljournal.model.JournalEntity;
import org.example.extendedtraveljournal.model.UserEntity;
import org.example.extendedtraveljournal.repository.JournalRepository;
import org.example.extendedtraveljournal.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.openapitools.model.Journal;
import org.openapitools.model.JournalPatchDto;
import org.openapitools.model.JournalPutDto;

import java.util.List;

@Service
public class JournalService {

  private final JournalRepository journalRepository;
  private final JournalMapper journalMapper;
  private final UserRepository userRepository;

  public JournalService(
      JournalRepository journalRepository,
      JournalMapper journalMapper,
      UserRepository userRepository) {
    this.journalRepository = journalRepository;
    this.journalMapper = journalMapper;
    this.userRepository = userRepository;
  }

  public Journal create(Journal journal) {
    Integer userId = journal.getUserId();
    if (userId == null) throw new IllegalArgumentException("userId is required");

    UserEntity user =
        userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(userId));

    JournalEntity entity = journalMapper.toEntity(journal);
    entity.setId(null);
    entity.setUser(user);

    JournalEntity saved = journalRepository.save(entity);
    return journalMapper.toDto(saved);
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
