package com.aluraCursos.librosyautores.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record RLibrosData(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<RAutorData> autor,
        @JsonAlias("languages") List<String> idiomas
) {
}
