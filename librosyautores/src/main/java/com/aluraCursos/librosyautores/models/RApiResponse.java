package com.aluraCursos.librosyautores.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record RApiResponse(
        @JsonAlias("results") List<RLibrosData> libros
) {
}
