package com.github.joanacoll.apibooks.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreRequestDto {
    private Long idGenre;
    @NotNull(message = "Please complete the gender name")
    private String name;

    public GenreRequestDto(String name) {
        this.name = name;
    }
}