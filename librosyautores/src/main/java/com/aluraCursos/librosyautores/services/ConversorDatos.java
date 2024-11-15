package com.aluraCursos.librosyautores.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConversorDatos implements IConversorDatos{
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T pasarDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json,clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
