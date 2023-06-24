package com.library.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @NotBlank( message = "Title should not be empty")
    @Column(name= "title", nullable = false, length = 32)
    private String title;
    @Size(min = 13, max = 13, message = "The size of ISBN must be 13")
    @Pattern(regexp = "[0-9]+", message = "ISBN must contain only digits")
    @Column(name = "isbn", nullable = false, length = 15, unique = true)
    private String isbn;
    @Column(name = "release_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Date needs to be set")
    private LocalDate releaseDate;
    @NotBlank(message = "Description should not be empty")
    @Column(name = "description")
    private String description;
    @NotNull
    @Column(name = "status")
    private BookStatus status;

    @Valid
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

}
