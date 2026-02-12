package com.challenge.buscador.literario.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
