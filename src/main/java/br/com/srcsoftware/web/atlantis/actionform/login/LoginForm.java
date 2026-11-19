package br.com.srcsoftware.web.atlantis.actionform.login;

import br.com.srcsoftware.web.atlantis.actionform.abstracts.AbstractUsuarioForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm extends AbstractUsuarioForm {

	private static final long serialVersionUID = 1L;

	// Dados de entrada da tela de login
	private String identificadorEmpresa;
	private String login;
	private String senha;
	private String email;

	

}