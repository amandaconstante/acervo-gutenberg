package com.challenge.buscador.literario.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroDtoResponse(String title,
                               List<PessoaDto> authors,
                               List<String> languages,
                               @JsonAlias(value = "download_count") Long downloadCount
) { }
