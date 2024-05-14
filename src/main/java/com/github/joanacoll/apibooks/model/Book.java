package com.github.joanacoll.apibooks.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBook;
    private String title;
    private String ISBN;
    private int year;
    private String language;
    private int pages;
    private String synopsis;
    private String cover;
    @ManyToMany
    private List<Genre> genres;
    @ManyToMany
    private List<Author> authors;
}