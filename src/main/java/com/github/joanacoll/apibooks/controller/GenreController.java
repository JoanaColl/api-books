package com.github.joanacoll.apibooks.controller;

import com.github.joanacoll.apibooks.dto.request.GenreRequestDto;
import com.github.joanacoll.apibooks.dto.response.GenreResponseDto;
import com.github.joanacoll.apibooks.dto.response.MessageResponseDto;
import com.github.joanacoll.apibooks.service.interfaces.IGenreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/genre")
public class GenreController {
    @Autowired
    IGenreService genreService;

    // -------------  CRUD METHODS  -------------
    @PostMapping("")
    public ResponseEntity<GenreResponseDto> createGenre(@RequestBody @Valid GenreRequestDto genreRequestDto) {
        return new ResponseEntity<>(genreService.create(genreRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreResponseDto> findByIdGenre(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(genreService.findById(id), HttpStatus.FOUND);
    }

    @GetMapping("")
    public ResponseEntity<List<GenreResponseDto>> findAllGenres() {
        return new ResponseEntity<>(genreService.findAll(), HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreResponseDto> updateGenre(@RequestBody @Valid GenreRequestDto genreRequestDto, @PathVariable (value = "id") Long id) {
        return new ResponseEntity<>(genreService.update(genreRequestDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponseDto> deleteGenre(@PathVariable (value = "id") Long id) {
        return new ResponseEntity<>(genreService.delete(id), HttpStatus.OK);
    }
}