package com.github.joanacoll.apibooks.utils;

import com.github.joanacoll.apibooks.model.Genre;
import com.github.joanacoll.apibooks.repository.IGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookUtils {

    @Autowired
    IGenreRepository genreRepository;

    public void validateGenres(List<Genre> bookGenres) {
        List<Genre> existingGenres = genreRepository.findAll();
        List<Genre> duplicateGenres = new ArrayList<>();

        for(Genre genre : bookGenres) {
            if(!duplicateGenres.contains(genre)) {
                duplicateGenres.add(genre);
            }
            else {
                throw new IllegalArgumentException("Duplicate genre!");
            }
        }

        for (Genre genre : bookGenres) {
            if (!existingGenres.contains(genre)) {
                throw new IllegalArgumentException("Genre not found!");
            }
        }
    }
}