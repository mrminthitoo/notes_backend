package com.mrminthitoo.notes_backend.services.implementations;

import com.mrminthitoo.notes_backend.models.dtos.NoteDto;
import com.mrminthitoo.notes_backend.models.entities.Note;
import com.mrminthitoo.notes_backend.repositories.NotesRepository;
import com.mrminthitoo.notes_backend.services.NotesService;
import com.mrminthitoo.notes_backend.utils.Mapper;
import com.mrminthitoo.notes_backend.utils.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotesServiceImplementation implements NotesService {

    @Autowired
    private NotesRepository notesRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public List<NoteDto> getNotes() {
        List<Note> notes = this.notesRepository.findAll();
        return this.mapper.mapList(notes, NoteDto.class);
    }

    @Override
    public NoteDto getNote(Long id) throws NotFoundException {
        Optional<Note> noteResult = this.notesRepository.findById(id);
        if (noteResult.isPresent()) {
            return this.mapper.map(noteResult.get(), NoteDto.class);
        }else {
            throw new NotFoundException(
                    "note not found.",
                    "id",
                    "note id " +  id + " not found."
            );
        }
    }

    @Override
    public NoteDto createNote(NoteDto noteDto) {
        Note note = new Note();
        note.setTitle(noteDto.getTitle());
        note.setBody(noteDto.getBody());
        note.setImage(noteDto.getImage());
        Note createdNote = this.notesRepository.save(note);
        return this.mapper.map(createdNote, NoteDto.class);
    }

    @Override
    public NoteDto updateNote(NoteDto noteDto) throws NotFoundException {
        Optional<Note> noteResult = this.notesRepository.findById(noteDto.getId());
        if (noteResult.isPresent()){

            Note note = noteResult.get();
            note.setTitle(noteDto.getTitle());
            note.setBody(noteDto.getBody());
            note.setImage(noteDto.getImage());
            Note updatedNote = this.notesRepository.save(note);
            return this.mapper.map(updatedNote, NoteDto.class);

        }else {

            throw new NotFoundException(
                    "note not found.",
                    "id",
                    "note id " +  noteDto.getId() + " not found."
            );

        }
    }

    @Override
    public NoteDto deleteNote(Long id) throws NotFoundException {
        Optional<Note> noteResult = this.notesRepository.findById(id);
        if (noteResult.isPresent()){
            Note note = noteResult.get();
            this.notesRepository.delete(note);
            return this.mapper.map(note, NoteDto.class);

        }else{

            throw new NotFoundException(
                    "note not found.",
                    "id",
                    "note id " +  id + " not found."
            );

        }
    }
}
