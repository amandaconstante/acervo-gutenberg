package com.challenge.buscador.literario.service;

import com.challenge.buscador.literario.dto.LivroDtoResponse;
import com.challenge.buscador.literario.dto.PessoaDto;
import com.challenge.buscador.literario.dto.ResponseDto;
import com.challenge.buscador.literario.entity.Livro;
import com.challenge.buscador.literario.entity.Pessoa;
import com.challenge.buscador.literario.repository.LivroRepository;
import com.challenge.buscador.literario.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BuscadorService {
    private final ConsumoApi consumoApi;
    private final ConverteDados converteDados;
    private final LivroRepository repository;
    private final PessoaRepository pessoaRepository;

    public BuscadorService(ConsumoApi consumoApi, ConverteDados converteDados,LivroRepository repository,PessoaRepository pessoaRepository) {
        this.consumoApi = consumoApi;
        this.converteDados = converteDados;
        this.repository = repository;
        this.pessoaRepository = pessoaRepository;
    }

    public void buscarLivroPorNome(String nomeLivro) {
        var nomeCodificado = URLEncoder.encode(nomeLivro, StandardCharsets.UTF_8);
        var address = "https://gutendex.com/books/?search=" + nomeCodificado;
        var response = consumoApi.getResponse(address);
        System.out.println(response);
        List<LivroDtoResponse> livros = converteDados.obterDados(response, ResponseDto.class).results();

        if (!livros.isEmpty()) {
            LivroDtoResponse livroEncontrado = livros.getFirst();
            Livro livro = new Livro(livroEncontrado.title(), livroEncontrado.languages(), livroEncontrado.downloadCount());
            System.out.println("quantos autores = " + livroEncontrado.authors().size());

            for (PessoaDto autorDto : livroEncontrado.authors()) {
                Optional<Pessoa> autorEncontrado = pessoaRepository.findByNomeIgnoreCase(autorDto.name());
                if (autorEncontrado.isPresent()) {
                    livro.getAutores().add(autorEncontrado.get());
                } else {
                    livro.getAutores().add(new Pessoa(autorDto.name(), autorDto.birthYear(), autorDto.deathYear()));
                }
            }
            repository.save(livro);
        } else {
            System.out.println("Obra não está disponível no acervo do Gutendex.");
        }
    }
}
