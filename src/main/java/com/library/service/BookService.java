package com.library.service;

import com.library.model.Book;
import com.library.model.BookStatus;

import java.util.List;

public interface BookService {

    Book findById(Long id);
    List<Book> findAll();
    Book findByTitleAndAuthor(String title, String authorName, String authorSurname);
    void changeStatus(Long id, BookStatus status);
    Book save(Book book);
    Book update(Long bookId, Book book);
    void delete(Long bookId);
    List<Book> sortByTitleAsc();
    List<Book> sortByAuthorAsc();
    List<Book> sortByDateAsc();

}
