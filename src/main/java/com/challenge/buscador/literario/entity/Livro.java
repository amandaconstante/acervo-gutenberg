package com.challenge.buscador.literario.entity;

import com.challenge.buscador.literario.dto.PessoaDto;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "livros_autores",
            joinColumns = @JoinColumn(name = "livro_id"),
            inverseJoinColumns = @JoinColumn(name = "pessoa_id")
    )
    private List<Pessoa> autores;
    private List<String> idiomas;
    private Long totalDownload;

    public Livro() {}

    public Livro(String titulo, List<String> idiomas, Long totalDownload) {
        this.titulo = titulo;
        this.idiomas = idiomas;
        this.totalDownload = totalDownload;
        this.autores = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Pessoa> getAutores() {
        return autores;
    }

    public void setAutores(List<Pessoa> autores) {
        this.autores = autores;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public Long getTotalDownload() {
        return totalDownload;
    }

    public void setTotalDownload(Long totalDownload) {
        this.totalDownload = totalDownload;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", idiomas=" + idiomas +
                ", totalDownload=" + totalDownload +
                ", autores=" + autores +
                '}';
    }
}
