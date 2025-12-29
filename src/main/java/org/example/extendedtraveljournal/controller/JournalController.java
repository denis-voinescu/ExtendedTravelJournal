package org.example.extendedtraveljournal.controller;

import org.example.extendedtraveljournal.service.JournalService;
import org.openapitools.model.Journal;
import org.openapitools.model.JournalPatchDto;
import org.openapitools.model.JournalPutDto;
import org.openapitools.api.JournalsApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JournalController implements JournalsApi {

  private final JournalService journalService;

  public JournalController(JournalService journalService) {
    this.journalService = journalService;
  }

  @Override
  public ResponseEntity<Journal> createJournal(Journal journal) {
    Journal created = journalService.create(journal);
    return ResponseEntity.status(HttpStatus.CREATED).body(created);
  }

  @Override
  public ResponseEntity<Void> deleteJournalById(Integer id) {
    journalService.deleteById(id);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @Override
  public ResponseEntity<List<Journal>> getAllJournals() {
    List<Journal> journals = journalService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(journals);
  }

  @Override
  public ResponseEntity<Journal> getJournalById(Integer id) {
    Journal journal = journalService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(journal);
  }

  @Override
  public ResponseEntity<Journal> patchJournalById(Integer id, JournalPatchDto journalPatchDto) {
    Journal journal = journalService.patchById(id, journalPatchDto);
    return ResponseEntity.status(HttpStatus.OK).body(journal);
  }

  @Override
  public ResponseEntity<Journal> putJournalById(Integer id, JournalPutDto journalPutDto) {
    Journal journal = journalService.putById(id, journalPutDto);
    return ResponseEntity.status(HttpStatus.OK).body(journal);
  }
}
