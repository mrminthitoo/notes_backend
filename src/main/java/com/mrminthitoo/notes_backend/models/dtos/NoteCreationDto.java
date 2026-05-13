package com.mrminthitoo.notes_backend.models.dtos;

import com.mrminthitoo.notes_backend.utils.validations.ImageFile;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Getter
@Setter
public class NoteCreationDto {

    private Long id;

    @Size(max = 200)
    private String title;

    @NotNull
    @Size(min= 1, max = 5000)
    private String body;

    @ImageFile
    private MultipartFile image;

    private Date createdAt;
    private Date updatedAt;

}
