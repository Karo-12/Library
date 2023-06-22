package com.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "author_id")
    private UUID id;
    @Column(name = "name", nullable = false, length = 15)
    private String name;
    @Column(name = "surname", nullable = false, length = 15)
    private String surname;
    @OneToMany(mappedBy = "author")
    private List<Book> releasedBooks;

}
