package com.github.joanacoll.apibooks.service.interfaces;

import com.github.joanacoll.apibooks.dto.request.AuthorRequestDto;
import com.github.joanacoll.apibooks.dto.response.AuthorResponseDto;

public interface IAuthorService extends ICrudService<AuthorResponseDto, AuthorRequestDto, Long> {

}