package com.challenge.buscador.literario.service;

import com.challenge.buscador.literario.dto.LivroDtoResponse;
import com.challenge.buscador.literario.dto.ResponseDto;
import com.challenge.buscador.literario.entity.Livro;
import com.challenge.buscador.literario.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class BuscadorService {
    private final ConsumoApi consumoApi;
    private final ConverteDados converteDados;
    private final LivroRepository repository;

    public BuscadorService(ConsumoApi consumoApi, ConverteDados converteDados,LivroRepository repository) {
        this.consumoApi = consumoApi;
        this.converteDados = converteDados;
        this.repository = repository;
    }

    public void buscarLivroPorNome(String nomeLivro) {
        var nomeCodificado = URLEncoder.encode(nomeLivro, StandardCharsets.UTF_8);
        var address = "https://gutendex.com/books/?search=" + nomeCodificado;

        var response = consumoApi.getResponse(address);

        System.out.println(response);

        ResponseDto resposta = converteDados.obterDados(response, ResponseDto.class);
        if (!resposta.results().isEmpty()) {
            LivroDtoResponse livroEncontrado = resposta.results().getFirst();
            Livro livro = new Livro(livroEncontrado.title(), livroEncontrado.authors(), livroEncontrado.languages(), livroEncontrado.downloadCount());
            repository.save(livro);
        } else {
            System.out.println("Obra não está disponível no acervo do Gutendex.");
        }

//        System.out.println("objeto convertido = ");
//        resposta.results().forEach(System.out::println);
//        System.out.println("1o retornado da busca: ");
//        System.out.println(resposta.results().getFirst());
    }
}
