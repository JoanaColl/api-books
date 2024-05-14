package com.github.joanacoll.apibooks.dto.response;

import com.github.joanacoll.apibooks.model.Author;
import com.github.joanacoll.apibooks.model.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {
    private Long idBook;
    private String title;
    private String isbn;
    private int year;
    private String language;
    private int pages;
    private String synopsis;
    private String cover;
    private List<Genre> genres;
    private List<Author> authors;
}