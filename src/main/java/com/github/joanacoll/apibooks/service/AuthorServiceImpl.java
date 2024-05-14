package com.github.joanacoll.apibooks.service;

import com.github.joanacoll.apibooks.dto.request.AuthorRequestDto;
import com.github.joanacoll.apibooks.dto.response.AuthorResponseDto;
import com.github.joanacoll.apibooks.dto.response.MessageResponseDto;
import com.github.joanacoll.apibooks.exception.EntityNotFoundException;
import com.github.joanacoll.apibooks.model.Author;
import com.github.joanacoll.apibooks.repository.IAuthorRepository;
import com.github.joanacoll.apibooks.service.interfaces.IAuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements IAuthorService {

    @Autowired
    IAuthorRepository authorRepository;

    ModelMapper modelMapper = new ModelMapper();

    // -------------  CRUD METHODS  -------------
    @Override
    public AuthorResponseDto create(AuthorRequestDto authorRequestDto) {
        Author author = authorRepository.save(modelMapper.map(authorRequestDto, Author.class));

        return modelMapper.map(author, AuthorResponseDto.class);
    }

    @Override
    public AuthorResponseDto findById(Long id) {
        Author authorResponse = authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Author not found!"));

        return modelMapper.map(authorResponse, AuthorResponseDto.class);
    }

    @Override
    public List<AuthorResponseDto> findAll() {
        List<Author> authorList = authorRepository.findAll();
        if(authorList.isEmpty()) {
            throw new EntityNotFoundException("Authors not found. List empty!");
        }

        List<AuthorResponseDto> authorResponseList = new ArrayList<>();
        authorList.stream().forEach(authorResponse -> authorResponseList.add(
                modelMapper.map(authorResponse, AuthorResponseDto.class)));
        return authorResponseList;
    }

    @Override
    public AuthorResponseDto update(AuthorRequestDto authorRequestDto, Long id) {
        if(!authorRepository.existsById(id)) {
            throw new EntityNotFoundException("Author not found!");
        }

        Author author = modelMapper.map(authorRequestDto, Author.class);
        author.setIdAuthor(id);
        Author authorResponse = authorRepository.save(author);

        return modelMapper.map(authorResponse, AuthorResponseDto.class);
    }

    @Override
    public MessageResponseDto delete(Long id) {
        if(!authorRepository.existsById(id)) {
            throw new EntityNotFoundException("Author not found!");
        }

        String authorNameDeleted = authorRepository.findById(id).get().getFirstname() + " " + authorRepository.findById(id).get().getLastname();
        authorRepository.deleteById(id);

        return new MessageResponseDto("Author: " + authorNameDeleted + " deleted!" );
    }
}