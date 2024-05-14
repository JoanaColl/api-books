package com.github.joanacoll.apibooks.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreResponseDto {
    private Long idGenre;
    private String name;
}