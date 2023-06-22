package com.library.repository;

import com.library.model.Author;
import com.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
    List<Book> findAllByOrderByAuthorAsc();
    List<Book> findAllByOrderByReleaseDateAsc();
    List<Book> findAllByOrderByTitleAsc();
    Optional<Book> findBookByTitleAndAuthor(String title, Author id);
}
