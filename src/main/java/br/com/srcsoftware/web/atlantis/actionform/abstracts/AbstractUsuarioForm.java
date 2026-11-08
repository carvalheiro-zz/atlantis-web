package br.com.srcsoftware.web.atlantis.actionform.abstracts;

import javax.servlet.http.HttpServletRequest;

import br.com.srcsoftware.web.atlantis.dto.manager.usuario.usuario.UsuarioSessaoPOJO;

public abstract class AbstractUsuarioForm extends AbstractForm{
	
	private static final long serialVersionUID = -7606089050493335926L;

	public UsuarioSessaoPOJO getUsuarioSessaoPOJO( HttpServletRequest meuRequest ) {
		UsuarioSessaoPOJO usuarioSessaoPOJO = (UsuarioSessaoPOJO) meuRequest.getSession().getAttribute( "usuarioSessaoPOJO" );
		return usuarioSessaoPOJO;
	}

	public void setUsuarioSessaoPOJO( HttpServletRequest meuRequest, UsuarioSessaoPOJO usuarioSessaoPOJO ) {

		/** Pega o Ip do usuario requisitante */
		String ipAddress = meuRequest.getHeader( "x-forwarded-for" );
		if ( ipAddress == null ) {
			ipAddress = meuRequest.getHeader( "X_FORWARDED_FOR" );
			if ( ipAddress == null ) {
				ipAddress = meuRequest.getRemoteAddr();
			}
		}
		usuarioSessaoPOJO.setIpCorrente( ipAddress );	

		meuRequest.getSession().setAttribute( "usuarioSessaoPOJO", usuarioSessaoPOJO );
	}

	public void removerUsuarioSessaoPOJO( HttpServletRequest meuRequest ) {
		meuRequest.getSession().removeAttribute( "usuarioSessaoPOJO" );
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
