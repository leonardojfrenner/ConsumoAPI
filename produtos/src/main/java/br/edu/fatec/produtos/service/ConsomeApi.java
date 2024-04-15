package br.edu.fatec.produtos.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsomeApi {

    public String obterDados(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new RuntimeException("Erro ao obter dados da API. Código de status: " + response.statusCode());
            }
            return response.body();
        } catch (IOException e) {
            throw new RuntimeException("Erro de IO ao fazer a requisição para a API", e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("A thread foi interrompida ao fazer a requisição para a API", e);
        }
    }
}
