package com.github.joanacoll.apibooks.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequestDto {
    private Long idAuthor;
    @NotNull(message = "Please complete the author firstname")
    private String firstname;
    @NotNull(message = "Please complete the author lastname")
    private String lastname;
    private String country;
    private String photo;

    public AuthorRequestDto(String firstname, String lastname, String country, String photo) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.country = country;
        this.photo = photo;
    }
}