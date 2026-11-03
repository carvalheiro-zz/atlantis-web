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
	
}
