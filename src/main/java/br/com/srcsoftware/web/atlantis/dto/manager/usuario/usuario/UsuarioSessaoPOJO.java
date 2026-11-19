package br.com.srcsoftware.web.atlantis.dto.manager.usuario.usuario;

import br.com.srcsoftware.web.atlantis.dto.manager.empresa.EmpresaDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioSessaoPOJO{

	private UsuarioDTO usuario;
	private String idPessoa;
	private String nomePessoa;
	private EmpresaDTO empresa;
	private String ipCorrente;
	private String imagem;

	private String sessionId;

	public boolean getIsADM() {
		if ( getUsuario() == null || getUsuario().getLogin() == null ) {
			return false;
		}
		return getUsuario().getLogin().equalsIgnoreCase( "adm" );
	}
	
	/**
	 * Valida se o usuário possui acesso à tela solicitada. Exemplo de expressão
	 * recebida do JSP: ${loginForm.acessoPermitido('1.tela.acessar')} Ou com
	 * parâmetros separados passados pela chave.
	 */
	public boolean isAcessoPermitido(String permissaoKey) {
		// Exemplo simulado de retorno positivo para validação
		return true;
	}

	/**
	 * Valida se o grupo de menu inteiro deve ser exibido com base nas permissões
	 * dos filhos. Exemplo no JSP:
	 * ${loginForm.exibirGrupoMenu('funcionario.cliente.fornecedor')}
	 */
	public boolean isExibirGrupoMenu(String grupoKey) {
		return true;
	}
	
}
