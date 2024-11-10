package com.aluraCursos.librosyautores.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String cumpleanios;
    private String fallecimiento;
    @ManyToMany(mappedBy = "autores")
    private List<Libros> libros;

    public Autor() {
    }

    public Autor(RAutorData autordata) {
        this.nombre = autordata.nombre();
        this.cumpleanios = autordata.cumple();
        this.fallecimiento = autordata.fallecimiento();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCumpleanios() {
        return cumpleanios;
    }

    public void setCumpleanios(String cumpleanios) {
        this.cumpleanios = cumpleanios;
    }

    public String getFallecimiento() {
        return fallecimiento;
    }

    public void setFallecimiento(String fallecimiento) {
        this.fallecimiento = fallecimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Libros> getLibros() {
        return libros;
    }

    public void setLibros(List<Libros> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Autor: "+ nombre + ", Cumpleaños: "+ cumpleanios + ", fallecio en: " + fallecimiento;
    }
}
