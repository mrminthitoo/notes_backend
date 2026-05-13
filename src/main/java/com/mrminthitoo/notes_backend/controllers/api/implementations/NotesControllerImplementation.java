package com.mrminthitoo.notes_backend.controllers.api.implementations;

import com.mrminthitoo.notes_backend.controllers.api.NotesController;
import com.mrminthitoo.notes_backend.models.dtos.NoteCreationDto;
import com.mrminthitoo.notes_backend.models.dtos.NoteDto;
import com.mrminthitoo.notes_backend.services.ImageUploadService;
import com.mrminthitoo.notes_backend.services.NotesService;
import com.mrminthitoo.notes_backend.utils.exception.NotFoundException;
import com.mrminthitoo.notes_backend.utils.exception.ValidationException;
import com.mrminthitoo.notes_backend.utils.response.APIResponse;
import com.mrminthitoo.notes_backend.utils.response.RESTResponser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class NotesControllerImplementation implements NotesController {

    @Autowired
    private NotesService notesService;

    @Autowired
    private ImageUploadService imageUploadService;

    @Autowired
    private APIResponse apiResponse;

    @Override
    public ResponseEntity<RESTResponser> getAllNotes() {
        List<NoteDto> notes = this.notesService.getNotes();
        return this.apiResponse.successResponse(
                HttpStatus.OK,
                "all notes.",
                notes
        );
    }

    @Override
    public ResponseEntity<RESTResponser> getNotes(Long id) throws NotFoundException {
        NoteDto note = this.notesService.getNote(id);
        return this.apiResponse.successResponse(
                HttpStatus.OK,
                "note.",
                note
        );
    }

    @Override
    public ResponseEntity<RESTResponser> createNote(NoteCreationDto note, BindingResult result) throws NotFoundException, ValidationException, IOException {
        if (!result.hasErrors()) {

            NoteDto noteDto = new NoteDto();
            noteDto.setTitle(note.getTitle());
            noteDto.setBody(note.getBody());

            if (note.getImage() != null && !note.getImage().isEmpty()) {
                String image = this.imageUploadService.uploadImage(note.getImage());
                noteDto.setImage(image);
            }

            NoteDto createdNote = this.notesService.createNote(noteDto);
            return this.apiResponse.successResponse(
                    HttpStatus.CREATED,
                    "created note.",
                    createdNote
            );

        }else{
            throw new ValidationException(
                    "validation failed.",
                    result.getFieldErrors()
            );
        }
    }

    @Override
    public ResponseEntity<RESTResponser> updateNote(Long id, NoteCreationDto note, BindingResult result) throws NotFoundException, ValidationException, IOException {

        if (!result.hasErrors()) {

            NoteDto noteDto = new NoteDto();
            noteDto.setId(id);
            noteDto.setTitle(note.getTitle());
            noteDto.setBody(note.getBody());
            if (note.getImage() != null && !note.getImage().isEmpty()) {
                String image = this.imageUploadService.uploadImage(note.getImage());
                noteDto.setImage(image);
            }
            note.setId(id);
            NoteDto updatedNote = this.notesService.updateNote(noteDto);
            return this.apiResponse.successResponse(
                    HttpStatus.CREATED,
                    "updated note.",
                    updatedNote
            );

        }else{
            throw new ValidationException(
                    "validation failed.",
                    result.getFieldErrors()
            );
        }

    }

    @Override
    public ResponseEntity<RESTResponser> deleteNote(Long id) throws NotFoundException {
        NoteDto note = this.notesService.deleteNote(id);
        return this.apiResponse.successResponse(
                HttpStatus.OK,
                "deleted note.",
                note
        );
    }

}
