package com.mrminthitoo.notes_backend.controllers.api;

import com.mrminthitoo.notes_backend.models.dtos.NoteCreationDto;
import com.mrminthitoo.notes_backend.models.dtos.NoteDto;
import com.mrminthitoo.notes_backend.utils.exception.NotFoundException;
import com.mrminthitoo.notes_backend.utils.exception.ValidationException;
import com.mrminthitoo.notes_backend.utils.response.RESTResponser;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequestMapping("/api/notes")
public interface NotesController {

    @GetMapping
    ResponseEntity<RESTResponser> getAllNotes();

    @GetMapping("/{id}")
    ResponseEntity<RESTResponser> getNotes(@PathVariable Long id) throws NotFoundException;

    @PostMapping(consumes = "multipart/form-data")
    ResponseEntity<RESTResponser> createNote(@Validated @ModelAttribute NoteCreationDto note, BindingResult result) throws NotFoundException, ValidationException, IOException;

    @PutMapping(path = "/{id}", consumes = "multipart/form-data")
    ResponseEntity<RESTResponser> updateNote(@PathVariable Long id, @Validated @ModelAttribute NoteCreationDto note, BindingResult result) throws NotFoundException, ValidationException, IOException;

    @DeleteMapping("/{id}")
    ResponseEntity<RESTResponser> deleteNote(@PathVariable Long id) throws NotFoundException;

}
