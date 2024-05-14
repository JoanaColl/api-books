package com.github.joanacoll.apibooks.service.interfaces;

import com.github.joanacoll.apibooks.dto.request.GenreRequestDto;
import com.github.joanacoll.apibooks.dto.response.GenreResponseDto;

public interface IGenreService extends ICrudService<GenreResponseDto, GenreRequestDto, Long>  {
    GenreResponseDto findByName (String name);
}