package org.example.extendedtraveljournal.repository;

import org.example.extendedtraveljournal.model.JournalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends JpaRepository<JournalEntity, Integer> {
}
