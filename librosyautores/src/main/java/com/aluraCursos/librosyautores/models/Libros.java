package com.aluraCursos.librosyautores.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Libros {
    @JsonProperty("id")
    private int id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("authors")
    private List<Autor> autor;
    @JsonProperty("language")
    private String idioma;

    public Libros() {
    }

    public Libros(int id, String title, List<Autor> autor, String idioma) {
        this.id = id;
        this.title = title;
        this.autor = autor;
        this.idioma = idioma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Titulo: " + title + ", Autor: "+ autor + ", Idioma: " + idioma;
    }
}
