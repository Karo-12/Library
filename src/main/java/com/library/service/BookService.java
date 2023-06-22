package com.library.service;

import com.library.model.Book;
import com.library.model.BookStatus;

import java.util.List;
import java.util.UUID;

public interface BookService {

    Book findById(UUID id);
    List<Book> findAll();
    Book findByTitleAndAuthor(String title, String authorName, String authorSurname);
    void changeStatus(UUID id, BookStatus status);
    Book save(Book book);
    Book update(UUID bookId, Book book);
    void delete(UUID bookId);
    List<Book> sortByTitleAsc();
    List<Book> sortByAuthorAsc();
    List<Book> sortByDateAsc();

}
