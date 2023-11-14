package com.minhaempresa.casacultural.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne; // Importe a anotação @ManyToOne
import jakarta.persistence.Table;

@Entity
@Table(name = "Analise")
public class Analise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne // Adicione a anotação para indicar a relação com Filme
    private Filme filme;
    
    private String analise;
    private int nota;

    // Construtores, getters e setters
    // Construtor vazio
    public Analise() {
    }

    // Construtor com parâmetros
    public Analise(Filme filme, String analise, int nota) {
        this.filme = filme;
        this.analise = analise;
        this.nota = nota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public String getAnalise() {
        return analise;
    }

    public void setAnalise(String analise) {
        this.analise = analise;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Object getComentario() {
        return null;
    }

    public void setComentario(Object comentario) {
    }
}
