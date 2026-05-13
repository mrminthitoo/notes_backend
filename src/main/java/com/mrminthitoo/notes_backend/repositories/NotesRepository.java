package com.mrminthitoo.notes_backend.repositories;

import com.mrminthitoo.notes_backend.models.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends JpaRepository<Note, Long> {
}
