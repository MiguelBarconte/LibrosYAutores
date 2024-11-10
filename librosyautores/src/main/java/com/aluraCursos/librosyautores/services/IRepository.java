package com.aluraCursos.librosyautores.services;

import com.aluraCursos.librosyautores.models.Libros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepository extends JpaRepository<Libros, Long> {

}
