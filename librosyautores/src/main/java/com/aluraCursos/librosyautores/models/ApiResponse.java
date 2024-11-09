package com.aluraCursos.librosyautores.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties()
public class ApiResponse {
    @JsonProperty("count")
    private int count;
    @JsonProperty("next")
    private String next;
    @JsonProperty("previous")
    private String previous;
    @JsonProperty("results")
    private List<Libros> libros;

    public ApiResponse() {
    }

    public ApiResponse(int count, String next, String previous, List<Libros> libros) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.libros = libros;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Libros> getLibros() {
        return libros;
    }

    public void setLibros(List<Libros> libros) {
        this.libros = libros;
    }
}
