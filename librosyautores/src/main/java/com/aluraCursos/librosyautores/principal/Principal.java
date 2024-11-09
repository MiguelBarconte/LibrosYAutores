package com.aluraCursos.librosyautores.principal;

import com.aluraCursos.librosyautores.models.ApiResponse;
import com.aluraCursos.librosyautores.models.DatosLibros;
import com.aluraCursos.librosyautores.services.ApiConsulta;
import com.aluraCursos.librosyautores.services.ConversorDatos;

import java.util.Scanner;

public class Principal {
    //Variables
    private Scanner scan = new Scanner(System.in);
    private ApiConsulta consulta = new ApiConsulta();
    private ConversorDatos conversor = new ConversorDatos();
    //Funciones y metodos
    public void principal() {
        int opc = -1;
        while (opc != 0) {
            menu();
            opc = scan.nextInt();
            scan.nextLine();
            switch (opc) {
                case 1:
                    BuscarPorTitulo();
                    break;
                case 2:
                    ListarLibros();
                    break;
                case 3:
                    ListarLibrosIdiomas();
                    break;
                case 4:
                    ListarAutores();
                    break;
                case 5:
                    ListarAutoresVivosEn();
                    break;
                case 0:
                    System.out.println("* Hasta la proxima *");
                    break;
                default:
                    System.out.println("* Por gente como tu, el shampoo trae instrucciones *");
                    break;
            }
        }
    }

    private void BuscarPorTitulo() {
        System.out.println("|* Nombre del libro q busca *|");
        String libro = scan.nextLine();
        String json = consulta.buscarLibro(libro);
        ApiResponse datos  = conversor.pasarDatos(json, ApiResponse.class);

        System.out.println(datos.getLibros());
    }
    private void ListarLibros(){}
    private void ListarLibrosIdiomas(){}
    private void ListarAutores(){}
    private void ListarAutoresVivosEn(){}

    public void menu() {
        System.out.println("""
                |********* Bienvenido *********|
                |*    Seleccione una opcion   *|
                |* 1- Buscar Libro por titulo *|
                |* 2- Listar libros buscados  *|
                |* 3- Listar por idioma       *|
                |* 4- Listar autores          *|
                |* 5- Listar autores vivos en *|
                |* 0- Salir                   *|
                |******************************|
                """
        );
    }
    
}//Ultima llave