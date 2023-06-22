package com.library.service;

import com.library.exception.EntityNotFoundException;
import com.library.model.Author;
import com.library.model.Book;
import com.library.model.BookStatus;
import com.library.repository.AuthorRepository;
import com.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    public Book findById(UUID id) {
        return bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find Book with id: " + id));
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findByTitleAndAuthor(String title, String authorName, String authorSurname) {
        Author authorToSearch = authorRepository.findByNameAndSurname(authorName, authorSurname)
                .orElseThrow(() -> new EntityNotFoundException("Could not find Author with name: " + authorName + " and surname: " + authorSurname));
        return bookRepository.findBookByTitleAndAuthor(title, authorToSearch)
                .orElseThrow(() -> new EntityNotFoundException("Could not find Book with title: " + title + " and author name and surname: " + authorName + " " + authorSurname));
    }

    @Override
    public void changeStatus(UUID id, BookStatus status) {
        Book bookToChange = findById(id);
        bookToChange.setStatus(status);
        save(bookToChange);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(UUID bookId, Book book) {
        book.setId(bookId);
        return bookRepository.save(book);
    }

    @Override
    public void delete(UUID bookId) {
        Book bookToDelete = findById(bookId);
        bookRepository.delete(bookToDelete);
    }

    @Override
    public List<Book> sortByTitleAsc() {
        return bookRepository.findAllByOrderByTitleAsc();
    }

    @Override
    public List<Book> sortByAuthorAsc() {
        return bookRepository.findAllByOrderByAuthorAsc();
    }

    @Override
    public List<Book> sortByDateAsc() {
        return bookRepository.findAllByOrderByReleaseDateAsc();
    }
}
