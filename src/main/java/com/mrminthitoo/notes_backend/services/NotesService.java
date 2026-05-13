package com.mrminthitoo.notes_backend.services;

import com.mrminthitoo.notes_backend.models.dtos.NoteDto;
import com.mrminthitoo.notes_backend.utils.exception.NotFoundException;

import java.util.List;

public interface NotesService {

    List<NoteDto> getNotes();
    NoteDto getNote(Long id) throws NotFoundException;
    NoteDto createNote(NoteDto noteDto);
    NoteDto updateNote(NoteDto noteDto) throws NotFoundException;
    NoteDto deleteNote(Long id) throws NotFoundException;

}
