package com.github.joanacoll.apibooks.repository;

import com.github.joanacoll.apibooks.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenreRepository extends JpaRepository<Genre, Long> {
    boolean existsByName (String name);
    Genre findByName (String name);
}