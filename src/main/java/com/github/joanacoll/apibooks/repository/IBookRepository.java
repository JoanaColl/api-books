package com.github.joanacoll.apibooks.repository;

import com.github.joanacoll.apibooks.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {
    boolean existsByISBN(String ISBN);
//    Book findByISBN(int ISBN);
//    Book findByYear(int year);
//    Book findByLanguage(String language);
//    Book findByPages(int pages);
//    List<Book> findByGenre(String nameGenre);
//    List<Book> findByAuthor(String nameAuthor);
//    boolean existsByTitle (String title);
//    Book findByTitle (String title);
}