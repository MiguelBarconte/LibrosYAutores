package com.aluraCursos.librosyautores.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="libro")
public class Libros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name="libro-autores",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autores = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private Idiomas idioma;

    public Libros() {
    }

    public Libros(RLibrosData libroData) {
        this.title = libroData.titulo();
        libroData.autor().forEach(e-> this.autores.add(new Autor(e)));
        this.idioma = Idiomas.fromString(libroData.idiomas().getFirst());
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

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Idiomas getIdioma() {
        return idioma;
    }

    public void setIdioma(Idiomas idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return """
                |*- - - - - - - - - - - - - - - - - - - - - - - - - - -*|
                |* Libro: %s
                |* %s
                |* Idioma: %s
                |*- - - - - - - - - - - - - - - - - - - - - - - - - - -*|
                """.formatted(title, autores.toString(), idioma);
    }
}
