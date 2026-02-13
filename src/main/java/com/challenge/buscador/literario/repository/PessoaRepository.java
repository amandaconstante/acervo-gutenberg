package com.challenge.buscador.literario.repository;

import com.challenge.buscador.literario.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findByNomeIgnoreCase(String nome);

    @Query("SELECT a FROM Pessoa a WHERE anoMorte > :ano AND anoNascimento <= :ano")
    List<Pessoa> buscarAutoresVivosNoAnoDe(long ano);
}
