package com.challenge.buscador.literario.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResponseDto(List<LivroDtoResponse> results) {
}
