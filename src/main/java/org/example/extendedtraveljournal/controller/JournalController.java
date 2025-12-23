package org.example.extendedtraveljournal.controller;

import org.openapitools.model.Journal;
import org.openapitools.model.JournalPatchDto;
import org.openapitools.model.JournalPutDto;
import org.openapitools.api.JournalsApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JournalController implements JournalsApi {
    @Override
    public ResponseEntity<Journal> createJournal(Journal journal) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteJournalById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<List<Journal>> getAllJournals() {
        return null;
    }

    @Override
    public ResponseEntity<Journal> getJournalById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<Journal> patchJournalById(Integer id, JournalPatchDto journalPatchDto) {
        return null;
    }

    @Override
    public ResponseEntity<Journal> putJournalById(Integer id, JournalPutDto journalPutDto) {
        return null;
    }
}
