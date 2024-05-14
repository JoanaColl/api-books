package com.github.joanacoll.apibooks.service.interfaces;

import com.github.joanacoll.apibooks.dto.response.MessageResponseDto;
import java.util.List;

public interface ICrudService <ResponseDto, RequestDto, id> {
    ResponseDto create(RequestDto requestDto);
    ResponseDto findById (Long id);
    List<ResponseDto> findAll();
    ResponseDto update(RequestDto requestDto, Long id);
    MessageResponseDto delete(Long id);
}