package com.aluraCursos.librosyautores.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConsulta {
    private final String URL = "https://gutendex.com/books/";
    private final HttpClient CLIENT = HttpClient.newHttpClient();
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
