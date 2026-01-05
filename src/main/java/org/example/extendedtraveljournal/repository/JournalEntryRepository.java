package org.example.extendedtraveljournal.repository;

import org.example.extendedtraveljournal.model.JournalEntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JournalEntryRepository extends JpaRepository<JournalEntryEntity, Integer> {
    List<JournalEntryEntity> findAllByJournalId(Integer journalId);
    Optional<JournalEntryEntity> findByIdAndJournalId(Integer id, Integer journalId);
    boolean existsByIdAndJournalId(Integer id, Integer journalId);
}
