package com.challenge.buscador.literario.repository;

import com.challenge.buscador.literario.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findByNomeIgnoreCase(String nome);
}
