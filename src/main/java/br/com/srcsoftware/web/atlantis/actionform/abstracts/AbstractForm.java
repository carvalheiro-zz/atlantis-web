package br.com.srcsoftware.web.atlantis.actionform.abstracts;

import org.apache.struts.action.ActionForm;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe respons�vel por representar a forma mais generalizada dos FORMs.
 * Classe que representa o formulario armazenando assim os valores dos campos em seus atributos.
 * 
 * @author Gabriel Damiani Carvalheiro <gabriel.carvalheiro@sigma.com.br>
 * @since 16/12/2011 18:01:19
 * @version 1.0
 */
@Getter
@Setter
public abstract class AbstractForm extends ActionForm{

	private static final long serialVersionUID = -2868245607072743286L;

	private String forwardDestino;

	private String idRegistroExcluir;


}
