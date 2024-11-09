package com.aluraCursos.librosyautores.services;

public interface IConversorDatos {
    <T> T pasarDatos(String json, Class<T> clase);
}
