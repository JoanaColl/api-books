package com.github.joanacoll.apibooks.controller;

import com.github.joanacoll.apibooks.dto.request.AuthorRequestDto;
import com.github.joanacoll.apibooks.dto.response.AuthorResponseDto;
import com.github.joanacoll.apibooks.dto.response.MessageResponseDto;
import com.github.joanacoll.apibooks.service.interfaces.IAuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/author")
public class AuthorController {
    @Autowired
    IAuthorService authorService;

    // -------------  CRUD METHODS  -------------
    @PostMapping("")
    public ResponseEntity<AuthorResponseDto> createAuthor(@RequestBody @Valid AuthorRequestDto authorRequestDto) {
        return new ResponseEntity<>(authorService.create(authorRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> findByIdAuthor(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(authorService.findById(id), HttpStatus.FOUND);
    }

    @GetMapping("")
    public ResponseEntity<List<AuthorResponseDto>> findAllAuthors() {
        return new ResponseEntity<>(authorService.findAll(), HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> updateAuthor(@RequestBody @Valid AuthorRequestDto authorRequestDto, @PathVariable (value = "id") Long id) {
        return new ResponseEntity<>(authorService.update(authorRequestDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponseDto> deleteAuthor(@PathVariable (value = "id") Long id) {
        return new ResponseEntity<>(authorService.delete(id), HttpStatus.OK);
    }
}