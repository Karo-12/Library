package com.library.service;

import com.library.model.Author;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthorService {

    List<Author> findAll();
    Optional<Author> findById(UUID id);
    Optional<Author> findByNameAndSurname(String surname);
    Author saveAuthor(Author author);
    Author deleteAuthor(UUID id);
}
