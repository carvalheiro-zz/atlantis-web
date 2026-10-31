package br.com.srcsoftware.web.atlantis.delegate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import br.com.srcsoftware.web.atlantis.dto.manager.usuario.tela.TelaDTO;
import br.com.srcsoftware.web.atlantis.dto.manager.usuario.tela.TelaFiltroDTO;
import br.com.srcsoftware.web.dto.response.ApiResponse;

@Disabled("Remova esta anotação temporariamente apenas quando a API Spring Boot estiver rodando na porta 8080")
class TelaDelegateLiveIntegrationTest {

    private final TelaDelegate telaDelegate = new TelaDelegate();

    @Test
    void deveListarTodasNaApiReal() {
        ApiResponse<List<TelaDTO>> response = telaDelegate.listarTodas();
        assertNotNull(response);
    }

    @Test
    void deveBuscarPorIdNaApiReal() {
        ApiResponse<TelaDTO> response = telaDelegate.buscarPorId("1");
        assertNotNull(response);
    }

    @Test
    void deveBuscarPorNomeNaApiReal() {
        ApiResponse<TelaDTO> response = telaDelegate.buscarPorNome("Dashboard");
        assertNotNull(response);
    }

    @Test
    void deveSalvarNaApiReal() {
        TelaDTO dto = new TelaDTO();
        dto.setNome("Tela Live Test");
        dto.setQuery("SELECT 1");

        ApiResponse<TelaDTO> response = telaDelegate.salvar(dto);
        assertNotNull(response);
    }

    @Test
    void deveAtualizarNaApiReal() {
        TelaDTO dto = new TelaDTO();
        dto.setId("1");
        dto.setNome("Tela Atualizada Live");
        dto.setQuery("SELECT 2");

        ApiResponse<TelaDTO> response = telaDelegate.atualizar(dto);
        assertNotNull(response);
    }

    @Test
    void deveDeletarNaApiReal() {
        ApiResponse<Void> response = telaDelegate.deletar("1");
        assertNotNull(response);
    }

    @Test
    void deveBuscarPorFiltroPaginadoNaApiReal() {
        TelaFiltroDTO filtro = new TelaFiltroDTO();
        filtro.setPagina(0);
        filtro.setTamanho(10);

        ApiResponse<Object> response = telaDelegate.buscarPorFiltroPaginado(filtro);
        assertNotNull(response);
    }
}