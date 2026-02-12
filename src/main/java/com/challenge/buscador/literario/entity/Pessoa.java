package com.challenge.buscador.literario.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    private Long anoNascimento;
    private Long anoMorte;

    public Pessoa() {}

    public Pessoa(String nome, Long anoNascimento, Long anoMorte) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.anoMorte = anoMorte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Long anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Long getAnoMorte() {
        return anoMorte;
    }

    public void setAnoMorte(Long anoMorte) {
        this.anoMorte = anoMorte;
    }
}
