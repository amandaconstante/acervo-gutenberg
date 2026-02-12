package com.challenge.buscador.literario.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public record PessoaDto(
        @JsonAlias(value = "birth_year") Long birthYear,
        @JsonAlias(value = "death_year") Long deathYear,
        String name) {
}
