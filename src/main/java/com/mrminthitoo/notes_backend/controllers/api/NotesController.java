package com.mrminthitoo.notes_backend.controllers.api;

import com.mrminthitoo.notes_backend.models.dtos.NoteCreationDto;
import com.mrminthitoo.notes_backend.utils.exception.NotFoundException;
import com.mrminthitoo.notes_backend.utils.exception.ValidationException;
import com.mrminthitoo.notes_backend.utils.response.RESTResponser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequestMapping("/api/notes")
public interface NotesController {

    @Tag(name = "notes API", description = "All NOTES APIs")

    @Operation(
            summary = "Get NOTEs",
            description = "Returns all notes."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "notes."),
    })
    @GetMapping
    ResponseEntity<RESTResponser> getAllNotes();

    @Operation(
            summary = "Get NOTE by ID",
            description = "Returns a single note"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "note."),
            @ApiResponse(responseCode = "404", description = "note not found.")
    })
    @GetMapping("/{id}")
    ResponseEntity<RESTResponser> getNotes(@PathVariable Long id) throws NotFoundException;

    @Operation(
            summary = "Create NOTE",
            description = "Returns created note"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "created note.")
    })
    @PostMapping(consumes = "multipart/form-data")
    ResponseEntity<RESTResponser> createNote(@Validated @ModelAttribute NoteCreationDto note, BindingResult result) throws NotFoundException, ValidationException, IOException;

    @Operation(
            summary = "Update NOTE",
            description = "Returns updated note"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "updated note."),
            @ApiResponse(responseCode = "404", description = "note not found.")
    })
    @PutMapping(path = "/{id}", consumes = "multipart/form-data")
    ResponseEntity<RESTResponser> updateNote(@PathVariable Long id, @Validated @ModelAttribute NoteCreationDto note, BindingResult result) throws NotFoundException, ValidationException, IOException;

    @Operation(
            summary = "Create NOTE",
            description = "Returns created note"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "deleted note."),
            @ApiResponse(responseCode = "404", description = "note not found.")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<RESTResponser> deleteNote(@PathVariable Long id) throws NotFoundException;

}
