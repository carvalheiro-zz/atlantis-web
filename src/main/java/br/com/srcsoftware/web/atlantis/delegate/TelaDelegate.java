package br.com.srcsoftware.web.atlantis.delegate;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.srcsoftware.web.atlantis.dto.manager.usuario.tela.TelaDTO;
import br.com.srcsoftware.web.atlantis.dto.manager.usuario.tela.TelaFiltroDTO;
import br.com.srcsoftware.web.dto.response.ApiResponse;
import br.com.srcsoftware.web.utilidades.JsonUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TelaDelegate {

    private static final String BASE_URL = "http://localhost:8080/api/v1/telas";

    private final String baseUrl;
    private final HttpClient httpClient;
    private final Gson gson;
 
    // Construtor padrão (produção)
    public TelaDelegate() {
        this(BASE_URL);
    }
    

 // Construtor para testes com URL customizada
    public TelaDelegate(String baseUrl) {
    	this.baseUrl = baseUrl;
        this.httpClient = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();
        this.gson = JsonUtils.getGson();
    }

 // Construtor completo para mocks (mantém compatibilidade)
    public TelaDelegate(HttpClient httpClient, Gson gson, String baseUrl) {
        this.httpClient = httpClient;
        this.gson = gson;
        this.baseUrl = baseUrl;
    }

    public ApiResponse<TelaDTO> salvar(TelaDTO dto) {
        return executarRequisicao(
            "salvar",
            HttpRequest.newBuilder()
                .uri(URI.create(baseUrl))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(dto)))
                .build(),
            new TypeToken<ApiResponse<TelaDTO>>() {}.getType()
        );
    }

    public ApiResponse<TelaDTO> atualizar(TelaDTO dto) {
        return executarRequisicao(
            "atualizar",
            HttpRequest.newBuilder()
                .uri(URI.create(baseUrl))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(gson.toJson(dto)))
                .build(),
            new TypeToken<ApiResponse<TelaDTO>>() {}.getType()
        );
    }

    public ApiResponse<Void> deletar(String id) {
        return executarRequisicao(
            "deletar",
            HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/" + id))
                .header("Accept", "application/json")
                .DELETE()
                .build(),
            new TypeToken<ApiResponse<Void>>() {}.getType()
        );
    }

    public ApiResponse<TelaDTO> buscarPorId(String id) {
        return executarRequisicao(
            "buscarPorId",
            HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/" + id))
                .header("Accept", "application/json")
                .GET()
                .build(),
            new TypeToken<ApiResponse<TelaDTO>>() {}.getType()
        );
    }

    public ApiResponse<TelaDTO> buscarPorNome(String nome) {
        return executarRequisicao(
            "buscarPorNome",
            HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/por-nome?nome=" + nome))
                .header("Accept", "application/json")
                .GET()
                .build(),
            new TypeToken<ApiResponse<TelaDTO>>() {}.getType()
        );
    }

    public ApiResponse<List<TelaDTO>> listarTodas() {
        return executarRequisicao(
            "listarTodas",
            HttpRequest.newBuilder()
                .uri(URI.create(baseUrl))
                .header("Accept", "application/json")
                .GET()
                .build(),
            new TypeToken<ApiResponse<List<TelaDTO>>>() {}.getType()
        );
    }

    public ApiResponse<Object> buscarPorFiltroPaginado(TelaFiltroDTO filtro) {
        return executarRequisicao(
            "buscarPorFiltroPaginado",
            HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/filtrar"))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(filtro)))
                .build(),
            new TypeToken<ApiResponse<Object>>() {}.getType()
        );
    }

    private <T> ApiResponse<T> executarRequisicao(String nomeServico, HttpRequest request, Type responseType) {
        long inicio = System.currentTimeMillis();
        log.info("Delegate: Iniciando chamada ao serviço [{}] URI: [{}]", nomeServico, request.uri());

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            long tempoDecorrito = System.currentTimeMillis() - inicio;

            log.info("Delegate: Finalizada chamada ao serviço [{}] com status HTTP [{}] em {} ms", 
                nomeServico, response.statusCode(), tempoDecorrito);

            return gson.fromJson(response.body(), responseType);

        } catch (Exception e) {
            long tempoDecorrito = System.currentTimeMillis() - inicio;
            log.error("Delegate: Erro ao executar o serviço [{}] após {} ms - Detalhes: {}", 
                nomeServico, tempoDecorrito, e.getMessage(), e);

            return ApiResponse.success(
                500,
                "Erro de comunicação com o serviço " + nomeServico + ": " + e.getMessage(),
                request.uri().getPath()
            );
        }
    }
}