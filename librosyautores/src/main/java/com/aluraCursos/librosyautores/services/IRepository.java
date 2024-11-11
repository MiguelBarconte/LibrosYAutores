package com.aluraCursos.librosyautores.services;

import com.aluraCursos.librosyautores.models.Idiomas;
import com.aluraCursos.librosyautores.models.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IRepository extends JpaRepository<Libros, Long> {
    List<Libros> findByIdioma(Idiomas idioma);
    @Query(value = "SELECT distinct nombre, cumpleanios, fallecimiento from autor join libro", nativeQuery = true)
    List<Object[]> buscarAutores();
}
