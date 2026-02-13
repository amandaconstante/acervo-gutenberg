package com.challenge.buscador.literario.repository;

import com.challenge.buscador.literario.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByIdiomas(String idioma);

    boolean existsByTituloIgnoreCase(String title);
}
