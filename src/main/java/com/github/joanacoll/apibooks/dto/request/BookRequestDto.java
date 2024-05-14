package com.github.joanacoll.apibooks.dto.request;

import com.github.joanacoll.apibooks.model.Author;
import com.github.joanacoll.apibooks.model.Genre;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDto {
    private Long idBook;
    @NotNull(message = "Please complete the book title")
    private String title;
    private String ISBN;
    private int year;
    private String language;
    private int pages;
    private String synopsis;
    private String cover;
    private List<Genre> genres;
    private List<Author> authors;

    public BookRequestDto(String title, String ISBN, int year, String language, int pages, String synopsis, String cover, List<Genre> genres, List<Author> authors) {
        this.title = title;
        this.ISBN = ISBN;
        this.year = year;
        this.language = language;
        this.pages = pages;
        this.synopsis = synopsis;
        this.cover = cover;
        this.genres = genres;
        this.authors = authors;
    }
}