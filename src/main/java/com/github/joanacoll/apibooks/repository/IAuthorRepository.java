package com.github.joanacoll.apibooks.repository;

import com.github.joanacoll.apibooks.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepository extends JpaRepository<Author, Long>  {
//    Author findByFirstname (String firstname);
//    Author findByLastname (String lastname);
//    List<Author> findByCountry(String country);
}