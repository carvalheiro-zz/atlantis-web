package br.com.srcsoftware.web.atlantis.actionform.abstracts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Classe que representa
 * 
 * @author Gabriel Damiani Carvalheiro <gabriel.carvalheiro@sigma.com.br>
 * @since 11/01/2012 17:00:17
 * @version 1.0
 */
public abstract class AbstractCRUDAction< T > extends AbstractUsuarioAction< T >{

	public abstract ActionForward abrirListagem( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response );

	public abstract ActionForward abrirCadastro( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response );

	public abstract ActionForward inserir( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response );

	public abstract ActionForward alterar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response );

	public abstract ActionForward excluir( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response );

	public abstract ActionForward filtrar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response );

	public abstract ActionForward selecionar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response );

	public abstract ActionForward limpar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response );

	public abstract ActionForward limparFiltro( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response );
}