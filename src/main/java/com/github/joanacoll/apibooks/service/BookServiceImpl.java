package com.github.joanacoll.apibooks.service;

import com.github.joanacoll.apibooks.dto.request.BookRequestDto;
import com.github.joanacoll.apibooks.dto.response.BookResponseDto;
import com.github.joanacoll.apibooks.dto.response.MessageResponseDto;
import com.github.joanacoll.apibooks.exception.EntityAlreadyExistException;
import com.github.joanacoll.apibooks.exception.EntityNotFoundException;
import com.github.joanacoll.apibooks.model.Book;
import com.github.joanacoll.apibooks.model.Genre;
import com.github.joanacoll.apibooks.repository.IBookRepository;
import com.github.joanacoll.apibooks.service.interfaces.IBookService;
import com.github.joanacoll.apibooks.utils.BookUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    IBookRepository bookRepository;
    @Autowired
    BookUtils bookUtils;

    ModelMapper modelMapper = new ModelMapper();

    // -------------  CRUD METHODS  -------------
    @Override
    public BookResponseDto create(BookRequestDto bookRequestDto) {
        if(bookRepository.existsByISBN(bookRequestDto.getISBN())) {
            throw new EntityAlreadyExistException("Book already exists!");
        }

        List<Genre> bookGenres = bookRequestDto.getGenres();
        bookUtils.validateGenres(bookGenres);

        Book bookResponse = bookRepository.save(modelMapper.map(bookRequestDto, Book.class));
        return modelMapper.map(bookResponse, BookResponseDto.class);
    }

    @Override
    public BookResponseDto findById(Long id) {
        Book bookResponse = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found!"));

        return modelMapper.map(bookResponse, BookResponseDto.class);
    }

    @Override
    public List<BookResponseDto> findAll() {
        List<Book> bookList = bookRepository.findAll();
        if(bookList.isEmpty()) {
            throw new EntityNotFoundException("Books not found. List empty!");
        }

        List<BookResponseDto> bookResponseList = new ArrayList<>();
        bookList.stream().forEach(bookResponse -> bookResponseList.add(
                modelMapper.map(bookResponse, BookResponseDto.class)));
        return bookResponseList;
    }

    @Override
    public BookResponseDto update(BookRequestDto bookRequestDto, Long id) {
        if(!bookRepository.existsById(id)) {
            throw new EntityNotFoundException("Book not found!");
        }

        Book book = modelMapper.map(bookRequestDto, Book.class);
        book.setIdBook(id);
        Book bookResponse = bookRepository.save(book);

        return modelMapper.map(bookResponse, BookResponseDto.class);
    }

    @Override
    public MessageResponseDto delete(Long id) {
        if(!bookRepository.existsById(id)) {
            throw new EntityNotFoundException("Book not found!");
        }

        String bookTitleDeleted = bookRepository.findById(id).get().getTitle();
        bookRepository.deleteById(id);

        return new MessageResponseDto("Book: " + bookTitleDeleted + " deleted!" );
    }
}