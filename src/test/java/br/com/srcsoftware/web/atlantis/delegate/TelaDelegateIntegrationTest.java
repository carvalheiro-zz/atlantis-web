package br.com.srcsoftware.web.atlantis.delegate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.http.HttpClient;
import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sun.net.httpserver.HttpServer;

import br.com.srcsoftware.web.atlantis.dto.manager.usuario.tela.TelaDTO;
import br.com.srcsoftware.web.atlantis.dto.manager.usuario.tela.TelaFiltroDTO;
import br.com.srcsoftware.web.dto.response.ApiResponse;
import br.com.srcsoftware.web.utilidades.JsonUtils;

class TelaDelegateIntegrationTest {

    private HttpServer server;
    private TelaDelegate telaDelegate;
    private String baseUrl;

    private String responsePayload;
    private int responseStatusCode;

    @BeforeEach
    void setUp() throws Exception {
        // Sobe o servidor HTTP nativo em uma porta aleatória livre
        server = HttpServer.create(new InetSocketAddress(0), 0);
        int port = server.getAddress().getPort();

        // Handler genérico reutilizável para interceptar todas as rotas sob /api/v1/telas
        server.createContext("/api/v1/telas", exchange -> {
            byte[] responseBytes = responsePayload != null ? responsePayload.getBytes() : new byte[0];
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(responseStatusCode, responseBytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(responseBytes);
            }
        });

        server.setExecutor(null);
        server.start();

        baseUrl = "http://localhost:" + port + "/api/v1/telas";
        telaDelegate = new TelaDelegate(baseUrl);
    }

    @AfterEach
    void tearDown() {
        if (server != null) {
            server.stop(0);
        }
    }

    @Test
    void deveTestarTodosOsConstrutoresParaCoberturaTotal() {
        // Construtor sem argumentos (padrão de produção)
        TelaDelegate delegatePadrao = new TelaDelegate();
        assertNotNull(delegatePadrao);

        // Construtor com baseUrl
        TelaDelegate delegateBaseUrl = new TelaDelegate(baseUrl);
        assertNotNull(delegateBaseUrl);

        // Construtor completo (httpClient, gson, baseUrl)
        HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(2)).build();
        TelaDelegate delegateCompleto = new TelaDelegate(client, JsonUtils.getGson(), baseUrl);
        assertNotNull(delegateCompleto);
    }

    @Test
    void deveSalvarTelaComSucesso() {
        TelaDTO dto = new TelaDTO();
        dto.setNome("Tela Cadastro");

        ApiResponse<TelaDTO> mockResponse = ApiResponse.success(201, "Criado com sucesso", dto, "/api/v1/telas");
        responsePayload = JsonUtils.toJson(mockResponse);
        responseStatusCode = 201;

        ApiResponse<TelaDTO> response = telaDelegate.salvar(dto);

        assertNotNull(response);
        assertTrue(response.success());
        assertEquals(201, response.status());
        assertNotNull(response.data());
        assertEquals("Tela Cadastro", response.data().getNome());
    }

    @Test
    void deveAtualizarTelaComSucesso() {
        TelaDTO dto = new TelaDTO();
        dto.setId("1");
        dto.setNome("Tela Edição");

        ApiResponse<TelaDTO> mockResponse = ApiResponse.success(200, "Atualizado com sucesso", dto, "/api/v1/telas");
        responsePayload = JsonUtils.toJson(mockResponse);
        responseStatusCode = 200;

        ApiResponse<TelaDTO> response = telaDelegate.atualizar(dto);

        assertNotNull(response);
        assertTrue(response.success());
        assertEquals(200, response.status());
        assertEquals("Tela Edição", response.data().getNome());
    }

    @Test
    void deveDeletarTelaComSucesso() {
        ApiResponse<Void> mockResponse = ApiResponse.success(200, "Removido com sucesso", "/api/v1/telas/1");
        responsePayload = JsonUtils.toJson(mockResponse);
        responseStatusCode = 200;

        ApiResponse<Void> response = telaDelegate.deletar("1");

        assertNotNull(response);
        assertTrue(response.success());
        assertEquals(200, response.status());
    }

    @Test
    void deveBuscarPorIdComSucesso() {
        TelaDTO dto = new TelaDTO();
        dto.setId("10");
        dto.setNome("Home");

        ApiResponse<TelaDTO> mockResponse = ApiResponse.success(200, "Encontrado", dto, "/api/v1/telas/10");
        responsePayload = JsonUtils.toJson(mockResponse);
        responseStatusCode = 200;

        ApiResponse<TelaDTO> response = telaDelegate.buscarPorId("10");

        assertNotNull(response);
        assertTrue(response.success());
        assertEquals(200, response.status());
        assertEquals("Home", response.data().getNome());
    }

    @Test
    void deveBuscarPorNomeComSucesso() {
        TelaDTO dto = new TelaDTO();
        dto.setNome("Admin");

        ApiResponse<TelaDTO> mockResponse = ApiResponse.success(200, "Encontrado", dto, "/api/v1/telas/por-nome");
        responsePayload = JsonUtils.toJson(mockResponse);
        responseStatusCode = 200;

        ApiResponse<TelaDTO> response = telaDelegate.buscarPorNome("Admin");

        assertNotNull(response);
        assertTrue(response.success());
        assertEquals(200, response.status());
        assertEquals("Admin", response.data().getNome());
    }

    @Test
    void deveListarTodasComSucesso() {
        List<TelaDTO> lista = List.of(new TelaDTO());
        ApiResponse<List<TelaDTO>> mockResponse = ApiResponse.success(200, "Lista recuperada", lista, "/api/v1/telas");
        responsePayload = JsonUtils.toJson(mockResponse);
        responseStatusCode = 200;

        ApiResponse<List<TelaDTO>> response = telaDelegate.listarTodas();

        assertNotNull(response);
        assertTrue(response.success());
        assertEquals(200, response.status());
        assertNotNull(response.data());
        assertEquals(1, response.data().size());
    }

    @Test
    void deveBuscarPorFiltroPaginadoComSucesso() {
        TelaFiltroDTO filtro = new TelaFiltroDTO();
        ApiResponse<Object> mockResponse = ApiResponse.success(200, "Filtrado", null, "/api/v1/telas/filtrar");
        responsePayload = JsonUtils.toJson(mockResponse);
        responseStatusCode = 200;

        ApiResponse<Object> response = telaDelegate.buscarPorFiltroPaginado(filtro);

        assertNotNull(response);
        assertTrue(response.success());
        assertEquals(200, response.status());
    }

    @Test
    void deveTratarErroDeComunicacaoQuandoServidorForEncerado() {
        // Encerra o servidor previamente para forçar exceção de conexão recusada no HttpClient
        server.stop(0);

        ApiResponse<TelaDTO> response = telaDelegate.buscarPorId("99");

        assertNotNull(response);
        assertEquals(500, response.status());
        assertTrue(response.message().contains("Erro de comunicação com o serviço buscarPorId"));
    }
}