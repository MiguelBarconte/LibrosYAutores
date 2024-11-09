package com.aluraCursos.librosyautores.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Autor {
    @JsonProperty("name")
    private String nombre;
    @JsonProperty("birth_year")
    private int cumpleanios;
    @JsonProperty("death_year")
    private int fallecimiento;

    public Autor() {
    }

    public Autor(int fallecimiento, int cumpleanios, String nombre) {
        this.fallecimiento = fallecimiento;
        this.cumpleanios = cumpleanios;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCumpleanios() {
        return cumpleanios;
    }

    public void setCumpleanios(int cumpleanios) {
        this.cumpleanios = cumpleanios;
    }

    public int getFallecimiento() {
        return fallecimiento;
    }

    public void setFallecimiento(int fallecimiento) {
        this.fallecimiento = fallecimiento;
    }

    @Override
    public String toString() {
        return "Autor: "+ nombre + ", Cumpleaños: "+ cumpleanios + ", fallecio en: " + fallecimiento;
    }
}
