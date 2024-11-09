package com.aluraCursos.librosyautores;

import com.aluraCursos.librosyautores.principal.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibrosyautoresApplication implements CommandLineRunner {
    @Autowired
    public static void main(String[] args) {
        SpringApplication.run(LibrosyautoresApplication.class, args);
    }

    @Override
	public void run(String... args) throws Exception{
        Principal principal = new Principal();
        principal.principal();
	}
}
