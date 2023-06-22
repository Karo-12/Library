package com.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;
    @NotBlank
    @Column(name= "title", nullable = false, length = 32)
    private String title;
    @NotBlank
    @Column(name = "isbn", nullable = false, length = 15)
    private String isbn;

    @Column(name = "release_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    @NotBlank
    @Column(name = "description")
    private String description;
    //@NotBlank
    @Column(name = "status")
    private BookStatus status;

    //@NotBlank
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @PrePersist
    void setStatus(){
        status = BookStatus.AVAILABLE;
    }
}
