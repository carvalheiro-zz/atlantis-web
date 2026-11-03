package br.com.srcsoftware.web.atlantis.actionform.abstracts;

import javax.servlet.http.HttpServletRequest;

/**
 * Classe respons�vel por representar a forma mais generalizada dos FORMs.
 * Classe que representa o formulario armazenando assim os valores dos campos em seus atributos.
 * 
 * @author Gabriel Damiani Carvalheiro <gabriel.carvalheiro@sigma.com.br>
 * @since 16/12/2011 18:01:19
 * @version 1.0
 */
public abstract class AbstractCRUDForm extends AbstractUsuarioForm{

	private static final long serialVersionUID = -1067116646761461915L;

	public abstract void limparCamposCadastro( HttpServletRequest request );

	public abstract void limparCamposConsulta( HttpServletRequest request );

	public abstract void limparLista();

	public void limparTudo( HttpServletRequest request ) {
		limparLista();
		limparCamposConsulta( request );
		limparCamposCadastro( request );

		setIdRegistroExcluir( null );

		request.getSession().removeAttribute( "erroAjax" );
		request.getSession().removeAttribute( "sucessoAjax" );
	}
}