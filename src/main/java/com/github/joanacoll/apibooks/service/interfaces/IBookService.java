package com.github.joanacoll.apibooks.service.interfaces;

import com.github.joanacoll.apibooks.dto.request.BookRequestDto;
import com.github.joanacoll.apibooks.dto.response.BookResponseDto;

public interface IBookService extends ICrudService<BookResponseDto, BookRequestDto, Long> {

}