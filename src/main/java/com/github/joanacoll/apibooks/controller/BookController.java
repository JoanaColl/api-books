package com.github.joanacoll.apibooks.controller;

import com.github.joanacoll.apibooks.dto.request.BookRequestDto;
import com.github.joanacoll.apibooks.dto.response.BookResponseDto;
import com.github.joanacoll.apibooks.dto.response.MessageResponseDto;
import com.github.joanacoll.apibooks.service.interfaces.IBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/book")
public class BookController {
    @Autowired
    IBookService bookService;

    // -------------  CRUD METHODS  -------------
    @PostMapping("")
    public ResponseEntity<BookResponseDto> createBook(@RequestBody @Valid BookRequestDto bookRequestDto) {
        return new ResponseEntity<>(bookService.create(bookRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> findByIdBook(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(bookService.findById(id), HttpStatus.FOUND);
    }

    @GetMapping("")
    public ResponseEntity<List<BookResponseDto>> findAllBooks() {
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDto> updateBook(@RequestBody @Valid BookRequestDto bookRequestDto, @PathVariable (value = "id") Long id) {
        return new ResponseEntity<>(bookService.update(bookRequestDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponseDto> deleteBook(@PathVariable (value = "id") Long id) {
        return new ResponseEntity<>(bookService.delete(id), HttpStatus.OK);
    }
}