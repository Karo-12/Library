package com.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long id;
    @NotBlank(message = "Name should not be blank")
    @Column(name = "name", nullable = false, length = 15)
    private String name;
    @NotBlank(message = "Surname should not be blank")
    @Column(name = "surname", nullable = false, length = 15)
    private String surname;
    @OneToMany(mappedBy = "author")
    private List<Book> releasedBooks;

}
