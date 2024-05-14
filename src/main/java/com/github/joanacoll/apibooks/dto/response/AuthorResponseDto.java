package com.github.joanacoll.apibooks.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponseDto {
    private Long idAuthor;
    private String firstname;
    private String lastname;
    private String country;
    private String photo;
}