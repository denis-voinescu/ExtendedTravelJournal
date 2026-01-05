package org.example.extendedtraveljournal.controller;

import org.example.extendedtraveljournal.service.JournalEntryService;
import org.openapitools.api.JournalEntriesApi;
import org.openapitools.model.JournalEntry;
import org.openapitools.model.JournalEntryPatchDto;
import org.openapitools.model.JournalEntryPutDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JournalEntryController implements JournalEntriesApi {

    private final JournalEntryService journalEntryService;

    public JournalEntryController(JournalEntryService journalEntryService) {
        this.journalEntryService = journalEntryService;
    }

    @Override
    public ResponseEntity<JournalEntry> createJournalEntry(Integer journalId, JournalEntry journalEntry) {
        JournalEntry created = journalEntryService.create(journalId, journalEntry);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Override
    public ResponseEntity<List<JournalEntry>> getAllJournalEntries(Integer journalId) {
        return ResponseEntity.ok(journalEntryService.getAllByJournalId(journalId));
    }

    @Override
    public ResponseEntity<JournalEntry> getJournalEntryById(Integer journalId, Integer entryId) {
        return ResponseEntity.ok(journalEntryService.getById(journalId, entryId));
    }

    @Override
    public ResponseEntity<JournalEntry> patchJournalEntryById(
            Integer journalId, Integer entryId, JournalEntryPatchDto journalEntryPatchDto) {
        return ResponseEntity.ok(journalEntryService.patchById(journalId, entryId, journalEntryPatchDto));
    }

    @Override
    public ResponseEntity<JournalEntry> putJournalEntryById(
            Integer journalId, Integer entryId, JournalEntryPutDto journalEntryPutDto) {
        return ResponseEntity.ok(journalEntryService.putById(journalId, entryId, journalEntryPutDto));
    }

    @Override
    public ResponseEntity<Void> deleteJournalEntryById(Integer journalId, Integer entryId) {
        journalEntryService.deleteById(journalId, entryId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
