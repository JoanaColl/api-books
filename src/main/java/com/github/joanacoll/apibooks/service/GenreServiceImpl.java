package com.github.joanacoll.apibooks.service;

import com.github.joanacoll.apibooks.dto.request.GenreRequestDto;
import com.github.joanacoll.apibooks.dto.response.GenreResponseDto;
import com.github.joanacoll.apibooks.dto.response.MessageResponseDto;
import com.github.joanacoll.apibooks.exception.EntityAlreadyExistException;
import com.github.joanacoll.apibooks.exception.EntityNotFoundException;
import com.github.joanacoll.apibooks.model.Genre;
import com.github.joanacoll.apibooks.repository.IGenreRepository;
import com.github.joanacoll.apibooks.service.interfaces.IGenreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class GenreServiceImpl implements IGenreService {
    @Autowired
    IGenreRepository genreRepository;

    ModelMapper modelMapper = new ModelMapper();

    // -------------  CRUD METHODS  -------------
    @Override
    public GenreResponseDto create(GenreRequestDto genreRequestDto) {
        if(genreRepository.existsByName(genreRequestDto.getName())) {
            throw new EntityAlreadyExistException("Genre already exists!");
        }

        Genre genreResponse = genreRepository.save(modelMapper.map(genreRequestDto, Genre.class));
        return modelMapper.map(genreResponse, GenreResponseDto.class);
    }

    @Override
    public GenreResponseDto findById(Long id) {
        Genre genreResponse = genreRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Genre not found!"));

        return modelMapper.map(genreResponse, GenreResponseDto.class);
    }

    @Override
    public List<GenreResponseDto> findAll() {
        List<Genre> genreList = genreRepository.findAll();
        if(genreList.isEmpty()) {
            throw new EntityNotFoundException("Genres not found. List empty!");
        }

        List<GenreResponseDto> genreResponseList = new ArrayList<>();
        genreList.stream().forEach(genreResponse -> genreResponseList.add(
                        modelMapper.map(genreResponse, GenreResponseDto.class)));
        return genreResponseList;
    }

    @Override
    public GenreResponseDto update(GenreRequestDto genreRequestDto, Long id) {
        if(!genreRepository.existsById(id)) {
            throw new EntityNotFoundException("Genre not found!");
        }
        if(genreRepository.existsByName(genreRequestDto.getName())) {
            throw new EntityAlreadyExistException("Genre already exists!");
        }

        Genre genre = modelMapper.map(genreRequestDto, Genre.class);
        genre.setIdGenre(id);
        Genre genreResponse = genreRepository.save(genre);

        return modelMapper.map(genreResponse, GenreResponseDto.class);
    }

    @Override
    public MessageResponseDto delete(Long id) {
        if(!genreRepository.existsById(id)) {
            throw new EntityNotFoundException("Genre not found!");
        }

        String genreNameDeleted = genreRepository.findById(id).get().getName();
        genreRepository.deleteById(id);

        return new MessageResponseDto("Genre: " + genreNameDeleted + " deleted!" );
    }

    @Override
    public GenreResponseDto findByName(String name) {
        Genre genreResponse = genreRepository.findByName(name);
        return modelMapper.map(genreResponse, GenreResponseDto.class);
    }
}