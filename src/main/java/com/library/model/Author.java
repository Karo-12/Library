package com.library.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Author {

    private UUID id;
    private String name;
    private String surname;
    private List<Book> releasedBooks;

}
