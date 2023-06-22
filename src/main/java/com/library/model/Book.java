package com.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "book_id")
    private UUID id;
    @Column(name= "title", nullable = false, length = 32)
    private String title;
    @Column(name = "isbn", nullable = false, length = 15)
    private String isbn;
    @Column(name = "release_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private BookStatus status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", nullable = false)
    private Author authors;

    @PrePersist
    void setStatus(){
        status = BookStatus.AVAILABLE;
    }
}
