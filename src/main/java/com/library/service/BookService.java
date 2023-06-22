package com.library.service;

import com.library.model.Book;
import com.library.model.BookStatus;

import java.util.List;
import java.util.UUID;

public interface BookService {

    Book findById(UUID id);
    List<Book> findAll();
    Book findByTitle(String title);
    void changeStatus(BookStatus status);
    Book save(Book book);
    Book update(UUID bookId, Book book);
    Book delete(UUID bookId);
    List<Book> sortByTitleAsc();
    List<Book> sortByAuthorAsc();
    List<Book> sortByDateAsc();

}
