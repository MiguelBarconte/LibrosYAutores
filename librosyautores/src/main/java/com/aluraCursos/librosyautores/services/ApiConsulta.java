package com.aluraCursos.librosyautores.services;

import com.aluraCursos.librosyautores.models.ApiResponse;
import com.aluraCursos.librosyautores.models.DatosLibros;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.autoconfigure.gson.GsonBuilderCustomizer;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ApiConsulta {
    private final String URL = "https://gutendex.com/books/";
    private final HttpClient CLIENT = HttpClient.newHttpClient();
    private ApiResponse json = new ApiResponse();
    public String buscarLibro(String nombreLibro){

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL+"?search="+nombreLibro))
                .build();
        HttpResponse<String> response = null;
        try {
            response = CLIENT
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String json = response.body();
        return json;
    }
}
