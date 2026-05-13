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
public class NoteDto {

    private Long id;
    private String title;
    private String body;
    private String image;
    private Date createdAt;
    private Date updatedAt;

}
