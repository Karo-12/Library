package com.library.service;

import com.library.model.Author;

import java.util.List;

public interface AuthorService {

    List<Author> findAll();
    Author findById(Long id);
    Author findByNameAndSurname(String name, String surname);
    Author saveAuthor(Author author);
    void deleteAuthor(Long id);
}
