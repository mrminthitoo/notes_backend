package com.mrminthitoo.notes_backend.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "notes")
public class Note extends Base{

    @Column(
            length = 200
    )
    private String title;

    @Column(
            length = 5000,
            nullable = false
    )
    private String body;

    @Column
    private String image;

}
