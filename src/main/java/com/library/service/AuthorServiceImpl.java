package com.library.service;

import com.library.exception.EntityNotFoundException;
import com.library.model.Author;
import com.library.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        return null;
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find Author with id: " + id));
    }

    @Override
    public Author findByNameAndSurname(String name, String surname) {
        return authorRepository.findByNameAndSurname(name, surname)
                .orElseThrow(() -> new EntityNotFoundException("Could not find Author with name: " + name + " and surname: " + surname));
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        Author authorToDelete = findById(id);
        authorRepository.delete(authorToDelete);
    }
}
