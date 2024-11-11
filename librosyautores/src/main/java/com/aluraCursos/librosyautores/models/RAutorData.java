package com.aluraCursos.librosyautores.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RAutorData(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") int cumple,
        @JsonAlias("death_year") int fallecimiento
) {
}
