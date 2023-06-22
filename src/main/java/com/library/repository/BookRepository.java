package com.library.repository;

import com.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
    List<Book> findByOrderByAuthorAsc();
    List<Book> findByOrderByReleaseDateAsc();
    List<Book> findByOrderByTitleAsc();
}
