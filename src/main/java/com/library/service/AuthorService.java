package com.library.service;

import com.library.model.Author;

import java.util.List;
import java.util.UUID;

public interface AuthorService {

    List<Author> findAll();
    Author findById(UUID id);
    Author findByNameAndSurname(String name, String surname);
    Author saveAuthor(Author author);
    void deleteAuthor(UUID id);
}
