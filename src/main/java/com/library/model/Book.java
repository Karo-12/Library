package com.library.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Book {

    private UUID id;
    private String title;
    private List<Author> authors;
    private String isbn;
    private LocalDate releaseDate;
    private String description;
    private BookStatus status;
}
