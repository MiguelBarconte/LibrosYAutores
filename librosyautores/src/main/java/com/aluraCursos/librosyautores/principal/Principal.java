package com.aluraCursos.librosyautores.principal;

import com.aluraCursos.librosyautores.models.*;
import com.aluraCursos.librosyautores.services.ApiConsulta;
import com.aluraCursos.librosyautores.services.ConversorDatos;
import com.aluraCursos.librosyautores.services.IRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    //Variables
    private Scanner scan = new Scanner(System.in);
    private ApiConsulta consulta = new ApiConsulta();
    private ConversorDatos conversor = new ConversorDatos();
    private List<RLibrosData> listaLibros;
    private IRepository repository;
    private List<Libros> misLibros = new ArrayList<>();
    private List<Autor> autorList = new ArrayList<>();
    //Funciones y metodos


    public Principal(IRepository repository) {
        this.repository = repository;
    }

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
        String json = consulta.buscarLibro(libro.replace(" ", "%20"));
        RApiResponse datos = conversor.pasarDatos(json, RApiResponse.class);
        listaLibros = datos.libros()
                .stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("|* Libros Encontrados *|");
        /*listaLibros.forEach(System.out::println);*/
        List<Libros> libros = listaLibros.stream()
                .map(record -> new Libros(record))
                .collect(Collectors.toList());
        for (Libros l : libros) {
            repository.save(l);
            System.out.println(l);
        }
    }

    private void ListarLibros() {
        misLibros = repository.findAll();
        System.out.println("|* Libros Buscados *|");
        misLibros.forEach(System.out::println);
    }

    private void ListarLibrosIdiomas() {
        System.out.println("|* Ingrese el idioma en q busca el libro *|");
        String text = scan.nextLine();
        Idiomas idioma = Idiomas.fromStringLanguage(text);
        misLibros = repository.findByIdioma(idioma);
        System.out.println("|* Libros en " + text + " *|");
        misLibros.forEach(System.out::println);
    }
    private void getAutores(){
        List<RAutorData> lista = new ArrayList<>();
        List<Object[]> respuesta = repository.buscarAutores();
        for (Object[] obj : respuesta) {
            String a = (String) obj[0];
            int b = (int) obj[1];
            int c = (int) obj[2];
            lista.add(new RAutorData(a, b, c));
        }
        lista.stream()
                .distinct()
                .collect(Collectors.toList())
                .forEach(e -> autorList.add(new Autor(e)));
    }
    private void ListarAutores() {
        getAutores();
        System.out.println("|* Autores guardados *|");
        autorList.forEach(System.out::println);
    }

    private void ListarAutoresVivosEn() {
        System.out.println("|* Ingrese el año *|");
        int anio = scan.nextInt();
        scan.nextLine();
        autorList.forEach(e->{
            if(e.getCumpleanios() <= anio && e.getFallecimiento()>= anio){
                System.out.println(e.toString());
            }
        });
    }

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