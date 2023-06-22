package com.library.service;

import com.library.model.Author;
import com.library.model.Book;
import com.library.model.BookStatus;
import com.library.repository.AuthorRepository;
import com.library.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {
    @Mock
    BookRepository bookRepository;
    @Mock
    AuthorRepository authorRepository;
    @InjectMocks
    BookServiceImpl bookService;
    @InjectMocks
    AuthorServiceImpl authorService;

    Book book;
    Book bookToUpdate;
    Author author;

    @BeforeEach
    void init() {

        author = new Author();
        author.setName("Stephen");
        author.setSurname("King");
        authorService.saveAuthor(author);

        book = new Book();
        book.setId(1L);
        book.setTitle("Carrie");
        book.setReleaseDate(LocalDate.of(1990, 1, 1));
        book.setIsbn("9788380973114");
        book.setDescription("Horror Book");
        book.setStatus(BookStatus.AVAILABLE);
        book.setAuthor(author);

        bookToUpdate = new Book();
        bookToUpdate.setTitle("Carrie");
        bookToUpdate.setReleaseDate(LocalDate.of(1990, 1, 1));
        bookToUpdate.setIsbn("9788380973114");
        bookToUpdate.setDescription("Horror Book");
        bookToUpdate.setStatus(BookStatus.BORROWED);
        bookToUpdate.setAuthor(author);

    }

    @Test
    void save() {
        when(bookRepository.save(any(Book.class))).thenReturn(book);
        Book savedBook = bookService.save(book);

        assertNotNull(savedBook);
    }

    @Test
    void update() {
        when(bookRepository.save(any(Book.class))).thenReturn(book);
        Book savedBook = bookService.save(book);

        when(bookRepository.save(any(Book.class))).thenReturn(bookToUpdate);
        Book updatedBook = bookService.update(savedBook.getId(), bookToUpdate);

        assertEquals(BookStatus.BORROWED, updatedBook.getStatus());

    }
}